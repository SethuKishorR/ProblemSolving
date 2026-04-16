package freecodecamp.programs;

import java.util.*;

public class _5_GroupAnagram {

    /*
    LeetCode: https://leetcode.com/problems/group-anagrams/

    Problem:
    Group strings that are anagrams of each other.

    Example:
    Input: ["eat","tea","tan","ate","nat","bat"]
    Output: [["eat","tea","ate"],["tan","nat"],["bat"]]

    Approach (Optimal - Frequency Count):
    - For each string, create a frequency array of size 26
    - Convert frequency array into a unique string key
    - Store strings in HashMap based on this key

    Time Complexity: O(n * k)
        n = number of strings
        k = max length of string

    Space Complexity: O(n)
    */

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        // Frequency array for characters a-z
        int[] freq = new int[26];

        for (String str : strs) {

            // Reset frequency array
            Arrays.fill(freq, 0);

            // Count characters
            for (char ch : str.toCharArray()) {
                freq[ch - 'a']++;
            }

            // Build unique key
            StringBuilder sb = new StringBuilder();
            for (int num : freq) {
                sb.append("#").append(num);
            }

            String key = sb.toString();

            // Add string to corresponding group
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        // Return grouped anagrams
        return new ArrayList<>(map.values());
    }
}