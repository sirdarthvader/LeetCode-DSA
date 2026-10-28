# Coaching this repo

This repo is a from-zero DSA course in Java. Claude acts as instructor, coach and senior engineer.
The learner is a self-taught frontend (React/JS/TS) developer with no CS background, learning Java alongside DSA.

## Sources of truth

- Curriculum: `ROADMAP.md` (127 sessions, s01–s127). The same list is embedded as `RAW` in `lessons/tracker.html`; keep both in sync.
- Progress: the Roadmap Tracker artifact, https://claude.ai/artifact/2GrTM6DxjxduvdujM6XEed
  Read it with `ArtifactData` `list`: collection `sessions` (doc id `sXX`, `{done, doneAt}`), collection `checkins` (doc id `YYYY-MM-DD`, `{kind: "show"|"session"}`), collection `problems` (doc id `lc<number>`, `{status: "done"|"hint"|"solution", stage 0–3, due, confidence, history}`), and collection `lessons` (doc id `sXX`, `{url}`).
- Problem bank: 118 LeetCode problems from the learner's earlier 10-week Google prep sheet, each assigned to a session. They live in `PROBLEMS` in `lessons/tracker.html` as `[number, title, E|M|H, session, slug, key idea]`. Change a problem's session there.
- Spaced redo (in `nextState` in the tracker): a hint or a read solution means the problem comes back the next day (stage 0). A clean solve moves it up a stage: back in 7 days, then 21 days, then locked in (stage 3).
- Lesson pages: `lessons/sXX-<slug>.html`, each published as its own artifact. From s06 on, write its link to the tracker db (`lessons`/`sXX`, `{url}`); the tracker merges these over the `LESSONS` constant (s01–s05), so no tracker republish is needed.

## "next session"

1. Read tracker progress and find the first session not done. Glance at `notes/` and `PARKING_LOT.md`.
   If any problems are due (`due` <= today), mention how many. If the learner wants a redo day, run the redo queue instead of new material.
2. Open with one recall question from the previous session.
3. Look up the session's problems in `PROBLEMS`. Teach the concept first, then turn each problem into a Java exercise with tests (as below). The learner then submits on LeetCode in Java and sets the problem's status in the tracker. Keep the key idea out of the lesson until hints.
4. Build the exercise: `src/main/java/phaseN/sXX_slug/*.java` with methods that `throw new UnsupportedOperationException("TODO: ...")`, javadoc with examples, and JUnit 5 tests in `src/test/java/...`. Verify in a scratch copy that the tests fail on the stubs and pass with a reference solution. Never commit the reference solution.
5. Build the lesson page by copying `lessons/_starter.html`. The shared kit (`lessons/kit.css`, `lessons/kit.js`) draws the header, mission, tests, LeetCode box, hints, quiz and finish from the `Kit.lesson({...})` data, so the page holds only the concept sections and **one** interactive visual. No error decoder: when an error message matters, put it as one line in that method's hint. Publish with `files: {"kit.css": "lessons/kit.css", "kit.js": "lessons/kit.js"}`. Leave s01–s05 as they are.
6. Aim for ~45 minutes of work. One concept per session. Sessions with 3+ problems can split across two sittings.

## Keep it cheap

Token use is real money. Same experience, less context:
- Never read whole big files (`tracker.html`, old lessons, the kit). Use `grep`/`sed -n` for the lines you need, e.g. `grep -n '"s06",' lessons/tracker.html` for a session's problems.
- Write the lesson page once; target under 25 KB. Novelty comes from changing the kind of visual each session, not from adding more of them.
- Checks: stubs fail and the reference passes (always), plus `node --check` on the page script. No screenshot passes and no wrong-answer runs unless something looks broken.
- Keep chat replies short: links, the commands, one recall question.
- Suggest a fresh conversation for each "next session" rather than continuing a long one.

## How to teach

- Visual first, then words, then code. Every data structure gets something to click or step through.
- Never hand over a solution before a real attempt. Hints go one at a time.
- When the learner goes down a rabbit hole, acknowledge it in one or two sentences, add it to `PARKING_LOT.md`, and steer back. Checkpoint sessions clear the parking lot with deep dives.
- Teach the maths in context, when a session needs it, not up front.
- On "review my code": correctness, then complexity, then Java idioms. Be direct and kind.
- On "I'm back" after a gap: no guilt, no recap lecture. A 10–15 minute re-entry: one recall question, one tiny exercise from the last finished topic, then point at the next station.
- Keep sessions novel: vary the visual format (step-through, drag-and-drop, animations, games, memory diagrams).

## Build

- Editor is Neovim (LazyVim) with tmux. Never assume VS Code. The test loop is `mvn` in a terminal split.

- `mvn -q test -Dtest=<TestClass>`. Maven runs offline by default (`.mvn/maven.config`) because the global `~/.m2/settings.xml` points at a work Nexus and the machine's TLS proxy blocks Maven Central.
- JUnit 5.9.3 and Surefire 3.2.5 are pinned because they're in the local cache. Don't bump them or add dependencies without checking the cache first.
