package phase0.s03_memory;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import org.junit.jupiter.api.Test;

class CopiesTest {

    @Test
    void copyHasTheSameValues() {
        assertArrayEquals(new int[] {1, 2, 3}, Copies.copy(new int[] {1, 2, 3}));
        assertArrayEquals(new int[] {}, Copies.copy(new int[] {}));
    }

    @Test
    void copyIsANewArray() {
        int[] original = {1, 2, 3};
        assertNotSame(original, Copies.copy(original));
    }

    @Test
    void copyAndOriginalAreIndependent() {
        int[] original = {1, 2, 3};
        int[] result = Copies.copy(original);
        result[0] = 99;
        original[1] = 42;
        assertArrayEquals(new int[] {1, 42, 3}, original);
        assertArrayEquals(new int[] {99, 2, 3}, result);
    }

    @Test
    void appendAddsToTheEnd() {
        assertArrayEquals(new int[] {1, 2, 3}, Copies.append(new int[] {1, 2}, 3));
        assertArrayEquals(new int[] {5}, Copies.append(new int[] {}, 5));
    }

    @Test
    void appendLeavesTheOriginalAlone() {
        int[] original = {1, 2};
        int[] longer = Copies.append(original, 3);
        assertNotSame(original, longer);
        assertArrayEquals(new int[] {1, 2}, original);
    }

    @Test
    void appendOverAndOver() {
        int[] nums = {};
        nums = Copies.append(nums, 1);
        nums = Copies.append(nums, 2);
        nums = Copies.append(nums, 3);
        assertArrayEquals(new int[] {1, 2, 3}, nums);
    }

    @Test
    void gridHasTheRightShapeAndValues() {
        assertArrayEquals(new int[][] {{4, 4, 4}, {4, 4, 4}}, Copies.grid(2, 3, 4));
        assertArrayEquals(new int[][] {{0}}, Copies.grid(1, 1, 0));
        assertEquals(0, Copies.grid(0, 5, 1).length);
    }

    @Test
    void gridRowsAreIndependent() {
        int[][] g = Copies.grid(3, 3, 0);
        g[0][0] = 1;
        assertArrayEquals(new int[][] {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}}, g);
        assertNotSame(g[0], g[1]);
        assertNotSame(g[1], g[2]);
    }
}
