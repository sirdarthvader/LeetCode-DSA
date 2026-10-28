package phase0.s05_collections;

import java.util.Map;

/**
 * Session 05 · Part B: HashMap, a key that points at a value.
 *
 * A JS Map is a HashMap in Java: set is put, has is containsKey. get on a missing
 * key gives null, Java's undefined.
 *
 * Map<String, Integer> ages = new HashMap<>();
 * ages.put("ada", 36);
 * ages.get("ada");            // 36
 * ages.get("bob");            // null
 * ages.containsKey("bob");    // false
 *
 * Run just these tests:  mvn -q test -Dtest=WordCountTest
 */
public class WordCount {

    /**
     * How many times each word appears. Upper and lower case count as different words.
     * count(["the", "cat", "the", "hat", "the"]) -> {the=3, cat=1, hat=1}
     * count([])                                -> {}
     */
    public static Map<String, Integer> count(String[] words) {
        throw new UnsupportedOperationException("TODO: implement count");
    }

    /**
     * The word that appears most often. words has at least one word.
     * If two words tie, return the one that appears first in the array.
     * mostCommon(["the", "cat", "the", "hat", "the"]) -> "the"
     * mostCommon(["b", "a", "a", "b"])                -> "b"
     */
    public static String mostCommon(String[] words) {
        throw new UnsupportedOperationException("TODO: implement mostCommon");
    }
}
