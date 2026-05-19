package freecodecamp.programs;

public class _17_MinWindowSubstring {

    /*
    LeetCode:
    https://leetcode.com/problems/minimum-window-substring/

    Problem:
    Given two strings s and t, return the minimum window substring of s
    such that every character in t (including duplicates) is included.

    If no such substring exists, return an empty string.

    Example:
    Input:  s = "ADOBECODEBANC", t = "ABC"
    Output: "BANC"

    Approach (Sliding Window + Frequency Array):
    - Store frequency of characters from t
    - Use two pointers (left, right) to expand/shrink window
    - Decrease count when a required character is found
    - When all characters are matched (count == 0):
        → Try shrinking window to find minimum
    - Track smallest valid window

    Key Idea:
    - count = number of characters still needed
    - freq[ch] > 0 → needed character
    - freq[ch] <= 0 → extra character

    Time Complexity: O(n)
    Space Complexity: O(1) (fixed size array 128)
    */

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        // Expected Output: "BANC"
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {

        // Edge case: if t is larger, no valid window
        if (s.length() < t.length()) {
            return "";
        }

        int left = 0, right = 0;
        int start = 0; // starting index of best window
        int minLength = Integer.MAX_VALUE;

        int count = t.length(); // number of chars still needed

        int[] freq = new int[128];

        // Step 1: Build frequency map for t
        for (char ch : t.toCharArray()) {
            freq[ch]++;
        }

        // Step 2: Expand window
        while (right < s.length()) {

            char r = s.charAt(right);

            // If this char is needed, reduce count
            if (freq[r] > 0) {
                count--;
            }

            freq[r]--; // include character in window
            right++;

            // Step 3: Shrink window when valid
            while (count == 0) {

                // Update minimum window
                if (right - left < minLength) {
                    minLength = right - left;
                    start = left;
                }

                char l = s.charAt(left);

                freq[l]++; // remove character from window

                // If this was a required character, window becomes invalid
                if (freq[l] > 0) {
                    count++;
                }

                left++;
            }
        }

        return minLength == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLength);
    }
}