package phase0.s03_memory;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class ArrayRefsTest {

    @Test
    void fillChangesTheCallersArray() {
        int[] nums = {1, 2, 3};
        ArrayRefs.fill(nums, 7);
        assertArrayEquals(new int[] {7, 7, 7}, nums);
    }

    @Test
    void fillReachesEveryArrowToTheSameArray() {
        int[] nums = {4, 5};
        int[] alias = nums;
        ArrayRefs.fill(alias, 0);
        assertArrayEquals(new int[] {0, 0}, nums);
    }

    @Test
    void fillOnAnEmptyArray() {
        int[] nums = {};
        ArrayRefs.fill(nums, 7);
        assertArrayEquals(new int[] {}, nums);
    }

    @Test
    void swapEndsSwapsInPlace() {
        int[] nums = {1, 2, 3, 4};
        ArrayRefs.swapEnds(nums);
        assertArrayEquals(new int[] {4, 2, 3, 1}, nums);

        int[] pair = {8, 9};
        ArrayRefs.swapEnds(pair);
        assertArrayEquals(new int[] {9, 8}, pair);
    }

    @Test
    void swapEndsOnShortArrays() {
        int[] one = {5};
        ArrayRefs.swapEnds(one);
        assertArrayEquals(new int[] {5}, one);

        int[] none = {};
        ArrayRefs.swapEnds(none);
        assertArrayEquals(new int[] {}, none);
    }
}
