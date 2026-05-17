package freecodecamp.programs;

import java.util.HashSet;

public class _15_LongestSubstringWithoutRepeatingChar {

    /*
    LeetCode:
    https://leetcode.com/problems/longest-substring-without-repeating-characters/

    Problem:
    Given a string s, find the length of the longest substring
    without repeating characters.

    Example:
    Input:  "ababcabcdefghijabcf"
    Output: 10
    Explanation: "abcdefghij" is the longest substring without duplicates

    Approach (Sliding Window + HashSet):
    - Use two pointers (left, right) to maintain a window
    - Use a HashSet to store characters in the current window
    - Expand window using right pointer
    - If duplicate found → shrink window from left until valid
    - Track maximum window size

    Time Complexity: O(n)
        Each character is added and removed at most once

    Space Complexity: O(n)
        HashSet stores unique characters in window
    */

    public static void main(String[] args) {
        String s = "ababcabcdefghijabcf";

        // Expected Output: 10
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {

        HashSet<Character> window = new HashSet<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            // Shrink window until duplicate is removed
            while (window.contains(current)) {
                window.remove(s.charAt(left));
                left++;
            }

            // Add current character to window
            window.add(current);

            // Update maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}