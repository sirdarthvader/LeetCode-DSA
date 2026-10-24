package phase0.s03_memory;

/**
 * Session 03 · Part A: one array, many arrows.
 *
 * An array variable doesn't hold the array. It holds an arrow to an array on the heap,
 * and a method you call gets a copy of that arrow. Follow the arrow and write, and the
 * caller sees the change. That's why these methods return nothing.
 *
 * Run just these tests:  mvn -q test -Dtest=ArrayRefsTest
 */
public class ArrayRefs {

    /**
     * Overwrite every slot of arr with value.
     * nums = {1, 2, 3}; fill(nums, 7);   // nums is now {7, 7, 7}
     * nums = {};        fill(nums, 7);   // nums is still {}
     */
    public static void fill(int[] arr, int value) {
        throw new UnsupportedOperationException("TODO: implement fill");
    }

    /**
     * Swap the first and last elements of arr, in place.
     * {1, 2, 3, 4} -> {4, 2, 3, 1}
     * {5}          -> {5}
     * {}           -> {}   (nothing to swap)
     */
    public static void swapEnds(int[] arr) {
        throw new UnsupportedOperationException("TODO: implement swapEnds");
    }
}
