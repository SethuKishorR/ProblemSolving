package freecodecamp.programs;

import java.util.Arrays;

public class _13_PermutationInString {

    /*
    Leetcode Link: https://leetcode.com/problems/permutation-in-string/

    Problem:
    Given two strings str1 and str2, return true if str2 contains
    a permutation of str1, otherwise return false.

    In other words, check if any substring of str2 is an anagram of str1.

    Example:
    Input: str1 = "abc", str2 = "abdefsjskslfjfjbac"
    Output: true
    Explanation:
    "bac" is a permutation of "abc" and exists in str2.

    Approach (Sliding Window + Frequency Count):
    - Use two frequency arrays of size 26 (for lowercase letters)
    - arr1 → stores frequency of str1
    - arr2 → stores frequency of current window in str2

    Steps:
    1. Fill arr1 with frequency of str1
    2. Traverse str2 using a sliding window of size k = str1.length()
        → Add current character to arr2
        → Remove character going out of window (when i >= k)
        → Compare arr1 and arr2
    3. If both arrays match → permutation found

    Time Complexity: O(n * 26) ≈ O(n)
    Space Complexity: O(1)
    */

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abdefsjskslfjfjbac";

        // Expected Output: true
        System.out.println(findPermutation(str1, str2));
    }

    public static boolean findPermutation(String str1, String str2) {

        if (str1.length() > str2.length()) return false;

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        int k = str1.length();

        // Build frequency array for str1
        for (int i = 0; i < k; i++) {
            arr1[str1.charAt(i) - 'a']++;
        }

        // Sliding window over str2
        for (int i = 0; i < str2.length(); i++) {

            // Add current character to window
            arr2[str2.charAt(i) - 'a']++;

            // Remove character going out of window
            if (i >= k) {
                arr2[str2.charAt(i - k) - 'a']--;
            }

            // Compare both frequency arrays
            if (Arrays.equals(arr1, arr2)) {
                return true;
            }
        }

        return false;
    }
}