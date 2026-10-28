package phase0.s05_collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ListBasicsTest {

    @Test
    void evensKeepsOrder() {
        assertEquals(List.of(2, 4, 6), ListBasics.evens(new int[] {1, 2, 3, 4, 6}));
    }

    @Test
    void evensHandlesNegativesAndZero() {
        assertEquals(List.of(-4, 0), ListBasics.evens(new int[] {-4, -3, 0, 7}));
    }

    @Test
    void evensCanBeEmpty() {
        assertEquals(List.of(), ListBasics.evens(new int[] {1, 3, 5}));
        assertEquals(List.of(), ListBasics.evens(new int[] {}));
    }

    @Test
    void reversedFlipsTheOrder() {
        assertEquals(List.of("c", "b", "a"), ListBasics.reversed(List.of("a", "b", "c")));
        assertEquals(List.of("solo"), ListBasics.reversed(List.of("solo")));
        assertEquals(List.of(), ListBasics.reversed(List.of()));
    }

    @Test
    void reversedLeavesTheOriginalAlone() {
        List<String> words = new ArrayList<>(List.of("a", "b", "c"));
        ListBasics.reversed(words);
        assertEquals(List.of("a", "b", "c"), words);
    }

    @Test
    void removeAllRemovesEveryCopy() {
        List<Integer> list = new ArrayList<>(List.of(3, 1, 3, 2, 3));
        ListBasics.removeAll(list, 3);
        assertEquals(List.of(1, 2), list);
    }

    @Test
    void removeAllRemovesNeighbours() {
        List<Integer> list = new ArrayList<>(List.of(5, 5, 5, 1, 5, 5));
        ListBasics.removeAll(list, 5);
        assertEquals(List.of(1), list);
    }

    @Test
    void removeAllRemovesTheValueNotTheIndex() {
        List<Integer> list = new ArrayList<>(List.of(10, 20, 30, 1));
        ListBasics.removeAll(list, 1);
        assertEquals(List.of(10, 20, 30), list);
    }

    @Test
    void removeAllWhenMissingChangesNothing() {
        List<Integer> list = new ArrayList<>(List.of(1, 2));
        ListBasics.removeAll(list, 9);
        assertEquals(List.of(1, 2), list);
    }
}
