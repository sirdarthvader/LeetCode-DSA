package phase0.s02_types;

/**
 * Session 02 · Part B: chars, Strings, and when == lies to you.
 *
 * The tests build some of their Strings and Integers in sneaky ways on purpose.
 * If a test fails with "expected: <2> but was: <0>", ask yourself which == you used.
 *
 * Run just these tests:  mvn -q test -Dtest=EqualityTest
 */
public class Equality {

    /**
     * How many times the character c appears in s. Case matters.
     * countChar("banana", 'a') -> 3
     * countChar("Hello", 'h')  -> 0
     */
    public static int countChar(String s, char c) {
      int count = 0;
      for(int i = 0; i < s.length(); i++) {
        if(s.charAt(i) == c) {
          count++;
        }
      }
      return count;
    }

    /**
     * How many words in the array are the same text as target.
     * countMatches(["cat", "dog", "cat"], "cat") -> 2
     * countMatches([], "cat")                    -> 0
     */
    public static int countMatches(String[] words, String target) {
      int count = 0;
      for(int i = 0; i < words.length; i++) {
        if(words[i].equals(target)) {
          count++;
        }
      }
      return count;
    }

    /**
     * True when a and b hold the same number. Neither is null.
     * sameValue(5, 5)       -> true
     * sameValue(1000, 1000) -> true
     * sameValue(1000, 1001) -> false
     */
    public static boolean sameValue(Integer a, Integer b) {
      if(a == null || b == null) {
        throw new IllegalArgumentException("Arguments cannot be null");
      }

      if((-128 <= a && a <= 127) && (-128 <= b && b <= 127)) {
        return a == b; // Use reference equality for small integers
      } else {
        return a.equals(b); // Use value equality for larger integers
      }
    }
}
