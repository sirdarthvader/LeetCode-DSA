package phase0.s01_hello_java;

/**
 * Session 01 · Part A: warm-up loops over arrays.
 *
 * Each method throws "TODO" right now, so its tests fail.
 * Replace the throw line with your code, run the tests, and watch them turn green.
 *
 * Run just these tests:  mvn -q test -Dtest=ArrayBasicsTest
 */
public class ArrayBasics {

    /**
     * Add up every number in the array.
     * sum([1, 2, 3]) -> 6
     * sum([])        -> 0
     */
    public static int sum(int[] nums) {
      int sum = 0;
      for(int i = 0; i < nums.length; i++){
        sum = sum + nums[i];
      }

      return sum;
    }

    /**
     * Return the largest number. You can assume nums has at least one element.
     * max([3, 9, 2]) -> 9
     * max([-5, -2])  -> -2   (careful: what should you start with?)
     */
    public static int max(int[] nums) {
      int largest = Integer.MIN_VALUE;
      for(int i = 0; i < nums.length; i++){
        largest = Math.max(largest, nums[i]);
      }

      return largest;
    }

    /**
     * Count how many numbers are even.
     * countEven([1, 2, 3, 4, 6]) -> 3
     */
    public static int countEven(int[] nums) {
      int result = 0;

      for(int i = 0; i < nums.length; i++) {
        if(nums[i] % 2 == 0) {
          result++;
        }
      }

      return result;
    }

    /**
     * Return a NEW array with the elements in reverse order. Do not change nums.
     * reversed([1, 2, 3]) -> [3, 2, 1]
     */
    public static int[] reversed(int[] nums) {
      int[] numsReversed = new int[nums.length];

      for(int i = nums.length - 1; i >= 0; i--){
        numsReversed[nums.length - 1 - i] = nums[i];
      }

      return numsReversed;
    }
}
