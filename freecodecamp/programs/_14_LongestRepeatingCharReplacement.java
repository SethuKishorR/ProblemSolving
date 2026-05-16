package freecodecamp.programs;

public class _14_LongestRepeatingCharReplacement {

    /*
    LeetCode:
    https://leetcode.com/problems/longest-repeating-character-replacement/

    Problem:
    Given a string s and an integer k, you can replace at most k characters.
    Find the length of the longest substring containing the same letter
    after performing at most k replacements.

    Example:
    Input: s = "ABAB", k = 2
    Output: 4

    Input: s = "AABABBA", k = 1
    Output: 4

    Approach (Sliding Window + Frequency Count):
    - Maintain a window using two pointers (left, right)
    - Track frequency of characters using an array
    - Keep track of maxCount (highest frequency in window)
    - If (window size - maxCount > k), shrink window
    - Update maxLength for valid windows

    Key Insight:
    - (window size - maxCount) = number of replacements needed
    - We allow at most k replacements

    Time Complexity: O(n)
    Space Complexity: O(1)
    */

    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;

        // Expected Output: 4
        System.out.println(characterReplacement(s, k));
    }

    public static int characterReplacement(String s, int k) {

        int left = 0;
        int maxCount = 0;   // max frequency in current window
        int maxLength = 0;

        int[] freq = new int[26];

        for (int right = 0; right < s.length(); right++) {
            int current = s.charAt(right) - 'A';
            // Add current character to window
            freq[current]++;
            // Update max frequency in window
            maxCount = Math.max(maxCount, freq[current]);

            // Shrink window if replacements exceed k
            while ((right - left + 1) - maxCount > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            // Update result
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}