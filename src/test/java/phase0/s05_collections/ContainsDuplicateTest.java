package phase0.s05_collections;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import org.junit.jupiter.api.Test;

class ContainsDuplicateTest {

    @Test
    void example1() {
        assertTrue(ContainsDuplicate.containsDuplicate(new int[] {1, 2, 3, 1}));
    }

    @Test
    void example2() {
        assertFalse(ContainsDuplicate.containsDuplicate(new int[] {1, 2, 3, 4}));
    }

    @Test
    void example3() {
        assertTrue(ContainsDuplicate.containsDuplicate(new int[] {1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }

    @Test
    void oneNumberHasNoDuplicate() {
        assertFalse(ContainsDuplicate.containsDuplicate(new int[] {7}));
    }

    @Test
    void negativesCount() {
        assertTrue(ContainsDuplicate.containsDuplicate(new int[] {-1, 5, -1}));
        assertFalse(ContainsDuplicate.containsDuplicate(new int[] {-1, 1}));
    }

    @Test
    void bigInputIsFast() {
        int[] nums = new int[200_000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i * 3;
        }
        assertTimeoutPreemptively(Duration.ofSeconds(2), () -> {
            assertFalse(ContainsDuplicate.containsDuplicate(nums));
        });
    }
}
