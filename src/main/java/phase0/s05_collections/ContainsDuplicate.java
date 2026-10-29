package phase0.s05_collections;

import java.util.*;

/**
 * Session 05 · Part C: LeetCode 217, Contains Duplicate.
 *
 * Given an integer array nums, return true if any value appears at least twice,
 * and false if every value is different.
 *
 * containsDuplicate([1, 2, 3, 1]) -> true
 * containsDuplicate([1, 2, 3, 4]) -> false
 * containsDuplicate([1, 1, 1, 3, 3, 4, 3, 2, 4, 2]) -> true
 *
 * nums can have up to 100,000 numbers, and LeetCode will time you.
 *
 * Run just these tests: mvn -q test -Dtest=ContainsDuplicateTest
 */
public class ContainsDuplicate {

  public static boolean containsDuplicate(int[] nums) {
    Set<Integer> seen = new HashSet<>();

    for (int i = 0; i < nums.length; i++) {
      if (seen.contains(nums[i])) {
        return true;
      } else {
        seen.add(nums[i]);
      }
    }

    return false;
  }
}
