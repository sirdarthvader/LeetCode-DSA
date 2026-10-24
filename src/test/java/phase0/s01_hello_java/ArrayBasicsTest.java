package phase0.s01_hello_java;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ArrayBasicsTest {

    @Test
    void sumAddsEverything() {
        assertEquals(6, ArrayBasics.sum(new int[] {1, 2, 3}));
        assertEquals(-4, ArrayBasics.sum(new int[] {-1, -3}));
    }

    @Test
    void sumOfEmptyArrayIsZero() {
        assertEquals(0, ArrayBasics.sum(new int[] {}));
    }

    @Test
    void maxFindsLargest() {
        assertEquals(9, ArrayBasics.max(new int[] {3, 9, 2}));
        assertEquals(7, ArrayBasics.max(new int[] {7}));
    }

    @Test
    void maxWorksWithAllNegatives() {
        assertEquals(-2, ArrayBasics.max(new int[] {-5, -2, -9}));
    }

    @Test
    void countEvenCountsEvens() {
        assertEquals(3, ArrayBasics.countEven(new int[] {1, 2, 3, 4, 6}));
        assertEquals(0, ArrayBasics.countEven(new int[] {1, 3, 5}));
        assertEquals(2, ArrayBasics.countEven(new int[] {0, -2}));
    }

    @Test
    void reversedReturnsReversedCopy() {
        assertArrayEquals(new int[] {3, 2, 1}, ArrayBasics.reversed(new int[] {1, 2, 3}));
        assertArrayEquals(new int[] {}, ArrayBasics.reversed(new int[] {}));
    }

    @Test
    void reversedDoesNotChangeInput() {
        int[] input = {1, 2, 3};
        ArrayBasics.reversed(input);
        assertArrayEquals(new int[] {1, 2, 3}, input);
    }
}
