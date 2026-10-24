package phase0.s02_types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class EqualityTest {

    @Test
    void countCharCountsEveryMatch() {
        assertEquals(3, Equality.countChar("banana", 'a'));
        assertEquals(1, Equality.countChar("banana", 'b'));
        assertEquals(0, Equality.countChar("", 'a'));
    }

    @Test
    void countCharIsCaseSensitive() {
        assertEquals(0, Equality.countChar("Hello", 'h'));
        assertEquals(1, Equality.countChar("Hello", 'H'));
    }

    @Test
    void countMatchesWithPlainStrings() {
        assertEquals(1, Equality.countMatches(new String[] {"cat", "dog"}, "dog"));
        assertEquals(0, Equality.countMatches(new String[] {}, "cat"));
    }

    @Test
    void countMatchesWithStringsBuiltAtRuntime() {
        // Same text, but each one is a separate String object.
        String[] words = {new String("cat"), "dog", new String("cat")};
        assertEquals(2, Equality.countMatches(words, "cat"));

        String built = new StringBuilder("do").append("g").toString();
        assertEquals(1, Equality.countMatches(words, built));
    }

    @Test
    void sameValueForSmallNumbers() {
        assertTrue(Equality.sameValue(5, 5));
        assertFalse(Equality.sameValue(5, 6));
    }

    @Test
    void sameValueForBigNumbers() {
        Integer a = 1000;
        Integer b = 1000;
        assertTrue(Equality.sameValue(a, b));
        assertFalse(Equality.sameValue(1000, 1001));
        assertTrue(Equality.sameValue(-500, -500));
    }
}
