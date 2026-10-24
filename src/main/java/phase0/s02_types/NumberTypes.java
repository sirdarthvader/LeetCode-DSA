package phase0.s02_types;

/**
 * Session 02 · Part A: numbers that don't fit.
 *
 * A Java int is a box with room for about ±2.1 billion. Push past that and it
 * silently wraps around to the other end. No error, no warning, just a wrong answer.
 *
 * Run just these tests:  mvn -q test -Dtest=NumberTypesTest
 */
public class NumberTypes {

    /**
     * The average of two non-negative ints, rounded down.
     * average(2, 4)  -> 3
     * average(3, 4)  -> 3
     * average(Integer.MAX_VALUE, Integer.MAX_VALUE) -> Integer.MAX_VALUE
     *   (careful: what is a + b here, before you divide?)
     */
    public static int average(int a, int b) {
        throw new UnsupportedOperationException("TODO: implement average");
    }

    /**
     * True when a + b gives the right answer as an int, false when it would overflow.
     * fitsInInt(1, 2)                  -> true
     * fitsInInt(Integer.MAX_VALUE, 1)  -> false
     * fitsInInt(Integer.MIN_VALUE, -1) -> false
     */
    public static boolean fitsInInt(int a, int b) {
        throw new UnsupportedOperationException("TODO: implement fitsInInt");
    }

    /**
     * n! = 1 × 2 × 3 × … × n, and 0! is 1. n is between 0 and 20.
     * factorial(5)  -> 120
     * factorial(13) -> 6227020800   (already too big for an int)
     * factorial(20) -> 2432902008176640000
     */
    public static long factorial(int n) {
        throw new UnsupportedOperationException("TODO: implement factorial");
    }
}
