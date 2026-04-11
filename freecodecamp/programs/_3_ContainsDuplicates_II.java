package freecodecamp.programs;

import java.util.HashSet;

public class _3_ContainsDuplicates_II {

    /*
    Leetcode Link: https://leetcode.com/problems/contains-duplicate-ii/
    Problem:
    Given an integer array nums and an integer k,
    return true if there are two distinct indices i and j such that:
        nums[i] == nums[j] AND |i - j| <= k

    Example:
    Input: nums = [1, 2, 1, 1, 4, 5, 6], k = 2
    Output: true

    Explanation:
    - nums[2] == nums[3] == 1
    - Distance = |2 - 3| = 1 <= 2 → valid

    Approach (Sliding Window + HashSet):
    - Maintain a window of size k using a HashSet
    - Traverse the array:
        → If current element already exists in set → duplicate within range → return true
        → Add current element to set
        → If window size exceeds k → remove element outside window

    Time Complexity: O(n)
    Space Complexity: O(k)
    */

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 1, 1, 4, 5, 6};
        int k = 2;

        // Expected Output: true
        System.out.println(containsNearbyDuplicate(nums, k));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        // Sliding window using HashSet
        HashSet<Integer> window = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            // If element already exists in window → duplicate found within k range
            if (window.contains(nums[i])) {
                return true;
            }

            // Add current element to window
            window.add(nums[i]);

            // Maintain window size ≤ k
            if (window.size() > k) {
                // Remove element that is out of current window range
                window.remove(nums[i - k]);
            }
        }

        // No nearby duplicates found
        return false;
    }
}