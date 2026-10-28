package phase0.s05_collections;

import java.util.ArrayList;
import java.util.List;

/**
 * Session 05 · Part A: ArrayList, the array that grows.
 *
 * A JS array is an ArrayList in Java: push is add, arr[i] is get(i), length is
 * size().
 * A plain int[] can't grow, so when you don't know the size up front, reach for
 * this.
 * It holds objects only, so a list of ints is written List<Integer>, not
 * List<int>.
 *
 * List<Integer> nums = new ArrayList<>();
 * nums.add(7);
 * nums.add(3);
 * nums.get(0); // 7
 * nums.size(); // 2
 *
 * Run just these tests: mvn -q test -Dtest=ListBasicsTest
 */
public class ListBasics {

  /**
   * A new list of the even numbers in nums, in the same order.
   * evens([1, 2, 3, 4, 6]) -> [2, 4, 6]
   * evens([-4, -3, 0, 7]) -> [-4, 0]
   * evens([1, 3, 5]) -> []
   */
  public static List<Integer> evens(int[] nums) {
    List<Integer> evenNums = new ArrayList<>();
    for (int n : nums) {
      if (Math.abs(n) % 2 == 0) {
        evenNums.add(n);
      }
    }
    return evenNums;
  }

  /**
   * A new list with the same words in reverse order. Don't change words itself.
   * reversed(["a", "b", "c"]) -> ["c", "b", "a"]
   */
  public static List<String> reversed(List<String> words) {
    List<String> reversedWords = new ArrayList<>();
    for (int i = words.size() - 1; i >= 0; i--) {
      reversedWords.add(words.get(i));
    }
    return reversedWords;
  }

  /**
   * Remove every copy of value from list. This one changes the list you're given,
   * so it returns nothing.
   * [3, 1, 3, 2, 3], remove 3 -> [1, 2]
   * [10, 20, 30, 1], remove 1 -> [10, 20, 30]
   * [1, 2], remove 9 -> [1, 2]
   */
  public static void removeAll(List<Integer> list, int value) {
    for (int i = list.size() - 1; i >= 0; i--) {
      if (list.get(i) == value) {
        list.remove(i);
      }
    }
  }
}
