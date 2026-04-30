package freecodecamp.programs;

import java.util.HashSet;

public class _10_LongestConsecutiveSequence {
    /*
    Leetcode Link: https://leetcode.com/problems/longest-consecutive-sequence/

    Problem:
    Given an unsorted array of integers, find the length of the longest
    consecutive elements sequence.

    Example:
    Input: nums = [1, 0, 1, 2]
    Output: 3
    Explanation: The longest consecutive sequence is [0, 1, 2]

    Approach (Optimized - HashSet):
    - Insert all elements into a HashSet for O(1) lookup
    - Iterate through the set (not array to avoid duplicates)
    - For each number, check if it is the start of a sequence
      (i.e., n - 1 is not in the set)
    - If it is a start:
        → Expand forward (n + 1, n + 2, ...)
        → Count sequence length
    - Track maximum length found

    Time Complexity: O(n)
    Space Complexity: O(n)
    */

    public static void main(String[] args) {
        int[] nums = {1,0,1,2};
        System.out.println(findLongestConsecutiveSequence(nums));
    }

    public static int findLongestConsecutiveSequence(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        int longestSub = 0;

        for (int n : set) {
            if (!set.contains(n - 1)) {
                int currentSub = 1;
                int currentElement = n;

                while (set.contains(currentElement + 1)) {
                    currentElement++;
                    currentSub++;
                }

                longestSub = Math.max(currentSub, longestSub);
            }
        }

        return longestSub;
    }
}