package phase0.s05_collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import org.junit.jupiter.api.Test;

class WordCountTest {

    @Test
    void countsEachWord() {
        String[] words = {"the", "cat", "the", "hat", "the"};
        assertEquals(Map.of("the", 3, "cat", 1, "hat", 1), WordCount.count(words));
    }

    @Test
    void countOfNothingIsEmpty() {
        assertEquals(Map.of(), WordCount.count(new String[] {}));
    }

    @Test
    void countIsCaseSensitive() {
        assertEquals(Map.of("Go", 1, "go", 2), WordCount.count(new String[] {"go", "Go", "go"}));
    }

    @Test
    void mostCommonFindsTheWinner() {
        assertEquals("the", WordCount.mostCommon(new String[] {"the", "cat", "the", "hat", "the"}));
        assertEquals("hat", WordCount.mostCommon(new String[] {"cat", "hat", "hat"}));
    }

    @Test
    void mostCommonOfOneWord() {
        assertEquals("solo", WordCount.mostCommon(new String[] {"solo"}));
    }

    @Test
    void mostCommonTieGoesToTheWordThatAppearsFirst() {
        assertEquals("b", WordCount.mostCommon(new String[] {"b", "a", "a", "b"}));
        assertEquals("amy", WordCount.mostCommon(new String[] {"cat", "amy", "zoe", "amy", "zoe"}));
    }
}
