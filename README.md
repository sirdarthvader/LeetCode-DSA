# DSA in Java

Learning data structures and algorithms from zero, in Java, one session at a time.
The full plan is in [ROADMAP.md](ROADMAP.md). Progress is tracked in the Roadmap Tracker page, which also holds
a 118-problem LeetCode bank (each problem attached to the session that teaches its pattern) and a spaced redo queue.

## Layout

```
src/main/java/phaseN/sXX_topic/   your code: each exercise starts as a TODO
src/test/java/phaseN/sXX_topic/   tests that tell you when you're done
notes/                            3 lines per session, in your own words
PARKING_LOT.md                    rabbit holes, saved for later
archive/js-2024/                  the 2024 JavaScript/TypeScript attempt
```

## Running tests

```bash
mvn -q test -Dtest=TwoSumTest
```

Red means not done yet. Green means done. That's the whole feedback loop.
Run every test with `mvn -q test`.

Maven runs offline (see `.mvn/maven.config`), so this works with or without a work VPN.
Everything needed is already in the local Maven cache.

Editor: Neovim. Keep a tmux split next to it and re-run the test command after each save.
For completion and inline errors, enable LazyVim's `lang.java` extra (`:LazyExtras`). It's optional: the compiler output from `mvn` tells you the same things.

## The rules

1. **Sessions, not days.** There's no schedule to fall behind on. You're only ever on the next session.
2. **Ten minutes counts.** On a bad day, open the repo, run one test, read one hint. Press "I showed up" in the tracker. That keeps the chain alive.
3. **Never miss twice.** Missing one day is normal. After a gap, the next session is a short re-entry, not a restart.
4. **Done is a green test.** Each session ends when its tests pass, not when you feel you've understood everything.
5. **Park rabbit holes.** When a "but how does X *really* work?" question hits mid-session, write it in `PARKING_LOT.md` and keep going. It isn't lost; every checkpoint has a deep dive that goes through the list.
6. **Try before hints, hints before answers.** Each lesson has hints that unlock one at a time. Use them in order. Full solutions only come after a real attempt.
7. **30 minutes, then a hint.** Still stuck after the hint? Read the solution, then re-implement it from scratch the next day. Mark it honestly (Done, Done with hint, Read solution) and the redo queue brings it back on the right day.
8. **Count patterns, not problems.** A problem counts once you can redo it a week later without notes.
9. **Explain it back.** Three lines in `notes/sXX.md`: what the idea is, when to use it, and what tripped you up.

## Working with Claude

Open this folder in Claude Code and say one of:

- `next session`: starts the next unchecked session with a lesson page and exercises
- `hint`: one nudge, no spoilers
- `review my code`: feedback on a passing solution (style, complexity, Java idioms)
- `I'm back`: after a gap, a short re-entry session to rebuild momentum
- `deep dive: <question>`: pull something from the parking lot now
