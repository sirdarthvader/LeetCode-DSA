// Shared lesson kit (s06 onwards). A lesson page holds only its concept sections and one visual inside
// <main class="wrap">, then calls Kit.lesson({...}). The kit adds the header and mission at the top, and
// the tests, LeetCode, hints, quiz and finish sections at the bottom. See _starter.html for every field.
window.Kit = (function () {
  const TRACKER = 'https://claude.ai/artifact/2GrTM6DxjxduvdujM6XEed';
  let prefix = 'kit:';
  const store = {
    get(k) { try { return JSON.parse(localStorage.getItem(prefix + k)); } catch (e) { return null; } },
    set(k, v) { try { localStorage.setItem(prefix + k, JSON.stringify(v)); } catch (e) {} }
  };
  const $ = (id) => document.getElementById(id);
  const esc = (s) => String(s).replace(/&/g, '&amp;').replace(/</g, '&lt;');
  const el = (tag, cls, html) => { const e = document.createElement(tag); if (cls) e.className = cls; if (html !== undefined) e.innerHTML = html; return e; };

  // Java colouring in one pass, so words inside spans we add are never touched.
  // Capitalised words count as types, a word before "(" as a method call.
  const TOK = /(\/\/.*$)|("[^"\n]*"|'[^'\n]*')|\b(new|return|for|while|if|else|import|package|static|public|private|final|void|true|false|null|class|this|throw|break|continue)\b|\b(int|long|double|char|boolean|[A-Z]\w*)\b|\b([a-z]\w*)(?=\()|\b(\d[\d_]*L?)\b/gm;
  const KINDS = ['com', 'str', 'kw', 'ty', 'fn', 'num'];
  function H(code) {
    let out = '', last = 0;
    code.replace(TOK, (m, ...g) => {
      const off = g[KINDS.length];
      out += esc(code.slice(last, off)) + '<span class="' + KINDS[g.findIndex((x, i) => i < KINDS.length && x !== undefined)] + '">' + esc(m) + '</span>';
      last = off + m.length;
      return m;
    });
    return out + esc(code.slice(last));
  }

  let boxes = [], total = 0;
  function updateMission() {
    const st = {}; let n = 0;
    boxes.forEach(b => { st[b.id] = b.checked; if (b.checked) n++; });
    store.set('mission', st);
    $('m-count').textContent = n === boxes.length ? n + ' / ' + n + ' · session complete' : n + ' / ' + boxes.length + ' · about ' + total + ' min';
    $('m-bar').style.width = (n / boxes.length * 100) + '%';
  }
  // Tick mission item n (1-based) from the page's own visual, e.g. when the learner finishes it.
  function tick(n) { const b = $('m' + n); if (b && !b.checked) { b.checked = true; updateMission(); } }

  function lesson(L) {
    prefix = L.id + ':';
    const num = parseInt(L.id.slice(1), 10);
    const main = document.querySelector('main');
    const mission = L.mission.concat([['Lock in: quiz, 3 lines in <code>notes/' + L.id + '.md</code>, tick ' + L.id + (L.leetcode ? ' and set the LeetCode status' : '') + ' in the tracker', 4]]);
    total = mission.reduce((s, m) => s + m[1], 0);

    const head = el('header', '', '<div class="eyebrow"><span class="tag">' + L.id + '</span> ' + L.phase + ' · session ' + num + ' of 127</div><h1>' + L.title + '</h1><p class="lede">' + L.lede + '</p>');
    head.style.cssText = 'display:grid; gap:16px';
    const ms = el('section', '', '<div class="mission"><div class="mission-head"><h2>Today\'s mission</h2><span class="muted" id="m-count"></span></div><div class="meter" aria-hidden="true"><i id="m-bar"></i></div><ol>' +
      mission.map((m, i) => '<li><label><input type="checkbox" id="m' + (i + 1) + '"><span>' + m[0] + '</span><span class="mins">' + m[1] + ' min</span></label></li>').join('') + '</ol></div>');
    main.prepend(head, ms);
    boxes = [...ms.querySelectorAll('input')];
    const saved = store.get('mission') || {};
    boxes.forEach(b => { b.checked = !!saved[b.id]; b.addEventListener('change', updateMission); });
    updateMission();

    if (L.tests) {
      const t = L.tests;
      const s = el('section', '', '<div class="eyebrow">Your turn</div><h2>Make the tests green</h2><p>Your files are in <code>' + t.dir + '</code>.' + (t.note ? ' ' + t.note : '') + '</p>');
      s.appendChild(el('div', 'files', t.files.map(f => '<div class="file"><b>' + f[0] + '</b><span>' + f[1] + '</span></div>').join('')));
      s.appendChild(el('pre', '', '<code>' + t.files.map(f => 'mvn -q test -Dtest=' + f[0] + 'Test').join('\n') + '</code>'));
      s.appendChild(el('p', 'muted', 'No output means every test passed.'));
      (L.leetcode || []).forEach(([n, name, slug, note]) => s.appendChild(el('div', 'lc', '<h3>Then on LeetCode</h3><p>Open <a href="https://leetcode.com/problems/' + slug + '/" target="_blank" rel="noopener">' + n + ' · ' + name + ' ↗</a> and switch the language to Java. ' + (note || '') + ' When it\'s accepted, set its status in the tracker.</p>')));
      main.appendChild(s);
    }

    if (L.hints) {
      const s = el('section', '', '<div class="eyebrow">Stuck?</div><h2>Hints, one at a time</h2><p>Give yourself 5 honest minutes on a method before opening a hint. Then take only one, and go try again.</p>');
      const opened = store.get('hints') || {};
      let lastGroup = '';
      L.hints.forEach(([group, name, list]) => {
        if (group !== lastGroup) { s.appendChild(el('div', 'hint-group', esc(group) + '.java')); lastGroup = group; }
        const key = group + ':' + name;
        const box = el('div', 'hint-set', '<header><code></code><button class="btn" type="button"></button></header><ol class="hint-list"></ol>');
        box.querySelector('code').textContent = name;
        const btn = box.querySelector('button'), ol = box.querySelector('ol');
        let shown = opened[key] || 0;
        const render = () => {
          ol.innerHTML = list.slice(0, shown).map(h => '<li>' + h + '</li>').join('');
          btn.textContent = shown === 0 ? 'Show hint 1' : shown < list.length ? 'Next hint (' + (shown + 1) + '/' + list.length + ')' : 'All hints shown';
          btn.disabled = shown >= list.length;
        };
        btn.addEventListener('click', () => { shown++; opened[key] = shown; store.set('hints', opened); render(); });
        render(); s.appendChild(box);
      });
      main.appendChild(s);
    }

    if (L.quiz) {
      const s = el('section', '', '<div class="eyebrow">Lock in</div><div class="deck-head"><h2>' + L.quiz.length + ' quick questions</h2><span class="score" id="score"></span></div>');
      const answered = store.get('quiz') || {};
      let right = 0;
      const score = () => { $('score').textContent = right + ' / ' + L.quiz.length; };
      L.quiz.forEach(([q, opts, ans, why], qi) => {
        const box = el('div', 'q', '<p><b>' + (qi + 1) + '.</b> ' + q + '</p><div class="opts"></div><p class="explain" hidden></p>');
        const ex = box.querySelector('.explain');
        const buttons = opts.map((o, oi) => {
          const b = el('button', 'opt', o); b.type = 'button';
          b.addEventListener('click', () => choose(oi)); box.querySelector('.opts').appendChild(b); return b;
        });
        function choose(oi, silent) {
          buttons.forEach((b, k) => { b.disabled = true; if (k === ans) b.classList.add('right'); if (k === oi && oi !== ans) b.classList.add('wrong'); });
          ex.hidden = false;
          ex.innerHTML = (oi === ans ? '<b style="color:var(--good)">Right.</b> ' : '<b style="color:var(--bad)">Not quite.</b> ') + why;
          if (oi === ans) right++;
          if (!silent) { answered[qi] = oi; store.set('quiz', answered); }
          score();
        }
        if (answered[qi] !== undefined && answered[qi] !== null) choose(answered[qi], true);
        s.appendChild(box);
      });
      main.appendChild(s);
      score();
    }

    main.appendChild(el('section', 'finish', '<h3>Done with all ' + mission.length + '?</h3><p>Write three lines in <code>notes/' + L.id + '.md</code>: the idea, when to use it, what tripped you up. Then tick ' + L.id + ' in your <a href="' + TRACKER + '" target="_blank" rel="noopener">Roadmap Tracker ↗</a>.</p>' + (L.next ? '<p class="muted">Next up: ' + L.next + '</p>' : '')));

    document.querySelectorAll('pre.java code').forEach(c => { c.innerHTML = H(c.textContent); });
  }

  return { lesson, tick, store, H, esc, $, el };
})();
