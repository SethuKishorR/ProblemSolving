package freecodecamp.programs;

import java.util.*;

public class _4_Anagram {

    /*
    LeetCode:
    https://leetcode.com/problems/valid-anagram/

    Problem:
    Check if two strings are anagrams (same characters with same frequency)

    Example:
    Input: "cat", "tac"
    Output: true

    Approaches:
    1. HashMap → O(n) time, O(n) space
    2. Array (optimal) → O(n) time, O(1) space

    */

    public static void main(String[] args) {
        String str1 = "cat";
        String str2 = "tac";

        // Expected Output: true
        System.out.println(isAnagram(str1, str2));

        // Optimal version
        System.out.println(isAnagramOptimal(str1, str2));
    }

    // 🔹 Approach 1: HashMap
    public static boolean isAnagram(String str1, String str2) {

        if (str1.length() != str2.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : str1.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : str2.toCharArray()) {

            if (!map.containsKey(ch)) {
                return false;
            }

            map.put(ch, map.get(ch) - 1);

            if (map.get(ch) == 0) {
                map.remove(ch);
            }
        }

        return map.isEmpty();
    }

    // 🔥 Approach 2: Optimal (Array)
    public static boolean isAnagramOptimal(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }

        for (int num : arr) {
            if (num != 0) {
                return false;
            }
        }

        return true;
    }
}