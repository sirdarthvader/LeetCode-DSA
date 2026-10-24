package phase0.s01_hello_java;
import java.util.HashMap;
import java.util.Map;

/**
 * Session 01 · Part B: LeetCode 1, Two Sum, the one you already solved in TypeScript.
 * Your old version is in archive/js/Arrays/TwoSum.ts. Translate it, don't copy it blind.
 *
 * Given an array of integers nums and an integer target, return the indices of the
 * two numbers that add up to target. Exactly one answer exists, and you may not use
 * the same element twice.
 *
 * Return the two indices with the smaller one first, e.g. [0, 1].
 *
 * twoSum([2, 7, 11, 15], 9) -> [0, 1]
 * twoSum([3, 2, 4], 6)      -> [1, 2]
 * twoSum([3, 3], 6)         -> [0, 1]
 *
 * Run just these tests:  mvn -q test -Dtest=TwoSumTest
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
      Map<Integer, Integer> seen = new HashMap<>();

      for(int i = 0; i < nums.length; i++) {
        int compliment = target - nums[i];
        if(seen.containsKey(compliment)) {
          return new int[] {seen.get(compliment), i};
        }
        seen.put(nums[i], i);
      }
      return new int[] {0, 0};
    }

}
