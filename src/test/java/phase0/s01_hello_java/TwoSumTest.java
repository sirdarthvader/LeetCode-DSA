package phase0.s01_hello_java;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class TwoSumTest {

    @Test
    void example1() {
        assertArrayEquals(new int[] {0, 1}, TwoSum.twoSum(new int[] {2, 7, 11, 15}, 9));
    }

    @Test
    void example2() {
        assertArrayEquals(new int[] {1, 2}, TwoSum.twoSum(new int[] {3, 2, 4}, 6));
    }

    @Test
    void duplicateValues() {
        assertArrayEquals(new int[] {0, 1}, TwoSum.twoSum(new int[] {3, 3}, 6));
    }

    @Test
    void negativeNumbers() {
        assertArrayEquals(new int[] {2, 4}, TwoSum.twoSum(new int[] {-1, -2, -3, -4, -5}, -8));
    }

    @Test
    void answerAtTheEnd() {
        assertArrayEquals(new int[] {3, 4}, TwoSum.twoSum(new int[] {1, 2, 3, 40, 50}, 90));
    }
}
