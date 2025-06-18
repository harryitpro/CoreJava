package algorithms.basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SlidingWindow_FixedTest {

    @Test
    @DisplayName("Test Case 1: Basic positive numbers")
    void testBasicPositiveNumbers() {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 3;
        // Expected:
        // [1, 2, 3] sum = 6
        // [2, 3, 4] sum = 9
        // [3, 4, 5] sum = 12
        // [4, 5, 6] sum = 15
        assertEquals(15, SlidingWindow_Fixed.maxSumSubarray(nums, k));
    }

    @Test
    @DisplayName("Test Case 2: Array with negative numbers")
    void testNegativeNumbers() {
        int[] nums = {-1, 2, 3, -4, 5, 6};
        int k = 3;
        // Expected:
        // [-1, 2, 3] sum = 4
        // [2, 3, -4] sum = 1
        // [3, -4, 5] sum = 4
        // [-4, 5, 6] sum = 7
        assertEquals(7, SlidingWindow_Fixed.maxSumSubarray(nums, k));
    }

    @Test
    @DisplayName("Test Case 3: All negative numbers")
    void testAllNegativeNumbers() {
        int[] nums = {-5, -2, -8, -1, -3};
        int k = 2;
        // Expected:
        // [-5, -2] sum = -7
        // [-2, -8] sum = -10
        // [-8, -1] sum = -9
        // [-1, -3] sum = -4
        assertEquals(-4, SlidingWindow_Fixed.maxSumSubarray(nums, k));
    }

    @Test
    @DisplayName("Test Case 4: k equals array length")
    void testKEqualsArrayLength() {
        int[] nums = {10, 20, 30};
        int k = 3;
        // Expected: [10, 20, 30] sum = 60
        assertEquals(60, SlidingWindow_Fixed.maxSumSubarray(nums, k));
    }

    @Test
    @DisplayName("Test Case 5: k equals 1")
    void testKEqualsOne() {
        int[] nums = {100, -50, 200, -10};
        int k = 1;
        // Expected: Max single element = 200
        assertEquals(200, SlidingWindow_Fixed.maxSumSubarray(nums, k));
    }

    @Test
    @DisplayName("Test Case 6: Empty array")
    void testEmptyArray() {
        int[] nums = {};
        int k = 3;
        // Expected: nums.length (0) < k (3) -> returns -1
        assertEquals(-1, SlidingWindow_Fixed.maxSumSubarray(nums, k));
    }

    @Test
    @DisplayName("Test Case 7: Array length less than k")
    void testArrayLengthLessThanK() {
        int[] nums = {1, 2};
        int k = 3;
        // Expected: nums.length (2) < k (3) -> returns -1
        assertEquals(-1, SlidingWindow_Fixed.maxSumSubarray(nums, k));
    }

    @Test
    @DisplayName("Test Case 8: Array with single element, k=1")
    void testSingleElementArrayK1() {
        int[] nums = {7};
        int k = 1;
        // Expected: [7] sum = 7
        assertEquals(7, SlidingWindow_Fixed.maxSumSubarray(nums, k));
    }

    @Test
    @DisplayName("Test Case 9: Array with repeating numbers")
    void testRepeatingNumbers() {
        int[] nums = {2, 2, 2, 2, 2};
        int k = 3;
        // Expected: [2, 2, 2] sum = 6
        assertEquals(6, SlidingWindow_Fixed.maxSumSubarray(nums, k));
    }

    @Test
    @DisplayName("Test Case 10: Mixed positive and negative, k large")
    void testMixedNumbersKLarge() {
        int[] nums = {1, -1, 2, -2, 3, -3, 4};
        int k = 4;
        // Expected:
        // [1, -1, 2, -2] sum = 0
        // [-1, 2, -2, 3] sum = 2
        // [2, -2, 3, -3] sum = 0
        // [-2, 3, -3, 4] sum = 2
        assertEquals(2, SlidingWindow_Fixed.maxSumSubarray(nums, k));
    }

    @Test
    @DisplayName("Test Case 11: Array with zeros")
    void testArrayWithZeros() {
        int[] nums = {0, 5, 0, 10, 0};
        int k = 2;
        // Expected:
        // [0, 5] sum = 5
        // [5, 0] sum = 5
        // [0, 10] sum = 10
        // [10, 0] sum = 10
        assertEquals(10, SlidingWindow_Fixed.maxSumSubarray(nums, k));
    }
}