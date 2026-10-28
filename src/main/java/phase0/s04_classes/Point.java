package phase0.s04_classes;

/**
 * Session 04 · Part B: constructors and final fields.
 *
 * A point on a grid. Its fields are public final: anyone can read p.x, and
 * nobody can
 * change it once the constructor has run. LeetCode's ListNode and TreeNode use
 * public
 * fields like these too.
 * A Point can't change, so moving one means making a new Point, the same idea
 * as
 * String in s03.
 *
 * Run just these tests: mvn -q test -Dtest=PointTest
 */
public class Point {

  public final int x;
  public final int y;

  /** new Point(3, 4) -> the point (3, 4) */
  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * new Point() -> the origin, (0, 0)
   * Bonus: do it in one line by reusing the constructor above.
   */
  public Point() {
    this.x = 0;
    this.y = 0;
  }

  /**
   * Grid distance: steps left or right, plus steps up or down, to get from this
   * point to other.
   * (1, 1) to (4, 5) -> 3 + 4 = 7
   * (2, 3) to (2, 3) -> 0
   * (0, 0) to (-2, 3) -> 5
   */
  public int manhattanTo(Point other) {
    return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
  }

  /**
   * A new point, shifted by dx and dy. This point stays where it is.
   * (1, 2).moved(3, -1) -> (4, 1)
   */
  public Point moved(int dx, int dy) {
    return new Point(x + dx, y + dy);
  }

  /**
   * How a Point prints: "(3, 4)"
   * Without this method, printing a Point shows something like Point@1b6d3586.
   */
  @Override
  public String toString() {
    return "(" + x + ", " + y + ")";
  }
}
