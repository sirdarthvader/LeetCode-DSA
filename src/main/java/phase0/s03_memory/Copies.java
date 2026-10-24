package phase0.s03_memory;

/**
 * Session 03 · Part B: when you need a second array.
 *
 * Copying an arrow is instant, but both arrows still point at the same array.
 * When you need an independent array, you have to make one with new.
 * The tests check that your result is a different array, not just equal values.
 *
 * Run just these tests:  mvn -q test -Dtest=CopiesTest
 */
public class Copies {

    /**
     * A new array holding the same values as arr. Changing one must not change the other.
     * copy({1, 2, 3}) -> {1, 2, 3}, but a different array
     * Write the loop yourself first. Once it's green, try arr.clone().
     */
    public static int[] copy(int[] arr) {
        throw new UnsupportedOperationException("TODO: implement copy");
    }

    /**
     * arr with x added on the end. Java arrays can't grow, so return a new, longer
     * array and leave arr exactly as it was.
     * append({1, 2}, 3) -> {1, 2, 3}
     * append({}, 5)     -> {5}
     * The caller keeps the result:  nums = append(nums, 3);
     */
    public static int[] append(int[] arr, int x) {
        throw new UnsupportedOperationException("TODO: implement append");
    }

    /**
     * A grid with rows rows and cols columns, every cell set to value.
     * Each row must be its own array: changing one row must not touch the others.
     * grid(2, 3, 0) -> {{0, 0, 0}, {0, 0, 0}}
     * grid(0, 5, 1) -> {}
     */
    public static int[][] grid(int rows, int cols, int value) {
        throw new UnsupportedOperationException("TODO: implement grid");
    }
}
