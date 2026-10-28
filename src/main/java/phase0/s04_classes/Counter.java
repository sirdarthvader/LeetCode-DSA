package phase0.s04_classes;

/**
 * Session 04 · Part A: your first class.
 *
 * A class is a blueprint. Every new Counter(...) is its own object on the heap,
 * with its
 * own copy of the fields. This time the fields are yours to write: add them
 * under the
 *
 * Counter likes = new Counter("likes");
 * likes.increment();
 * likes.add(5);
 * likes.value(); // 6
 * likes.label(); // "likes"
 *
 * Run just these tests: mvn -q test -Dtest=CounterTest
 */
public class Counter {
  int value;
  String label;

  /**
   * A new counter with this label, starting at 0.
   * new Counter("likes").value() -> 0
   */
  public Counter(String label) {
    this.label = label;
    value = 0;
  }

  /** Add 1 to the count. */
  public void increment() {
    value++;
  }

  /**
   * Add n to the count. n can be negative.
   * at 3, add(4) -> 7
   * at 3, add(-5) -> -2
   */
  public void add(int n) {
    value += n;
  }

  /** The current count. */
  public int value() {
    return value;
  }

  /** The label this counter was made with. */
  public String label() {
    return label;
  }

  /** Back to 0. The label stays the same. */
  public void reset() {
    value = 0;
  }
}
