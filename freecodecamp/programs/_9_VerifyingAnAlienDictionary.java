package freecodecamp.programs;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem: Verifying an Alien Dictionary
 * Link: https://leetcode.com/problems/verifying-an-alien-dictionary/
 *
 * Approach:
 * - Store the order of characters in a map (character → index)
 * - Compare each adjacent pair of words
 * - For each pair:
 *     - Compare characters one by one
 *     - If mismatch found → decide order using map
 *     - If no mismatch → check prefix condition
 *
 * Time Complexity: O(N * M)
 *   N = number of words, M = average length of word
 *
 * Space Complexity: O(1)
 *   (only 26 lowercase letters stored in map)
 */
public class _9_VerifyingAnAlienDictionary {

    private static final Map<Character, Integer> DICTIONARY = new HashMap<>();

    public static void main(String[] args) {
        String[] words = {"hello", "leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";

        // Build dictionary
        for (int i = 0; i < order.length(); i++) {
            DICTIONARY.put(order.charAt(i), i);
        }

        boolean result = isAlienSorted(words);

        System.out.println("Input  : " + String.join(", ", words));
        System.out.println("Order  : " + order);
        System.out.println("Output : " + result);
    }

    public static boolean isAlienSorted(String[] words) {
        for (int i = 0; i < words.length - 1; i++) {
            String str1 = words[i];
            String str2 = words[i + 1];

            int j = 0;

            // Compare characters
            while (j < str1.length() && j < str2.length()) {
                char ch1 = str1.charAt(j);
                char ch2 = str2.charAt(j);

                if (ch1 != ch2) {
                    // If characters are different, compare using alien order
                    if (DICTIONARY.get(ch1) > DICTIONARY.get(ch2)) {
                        return false;
                    }
                    // If order is correct, no need to check further characters
                    break; // move to next pair of words
                }
                j++;
            }


            // Prefix case (e.g., "apple" comes before "app" → invalid)
            // This happens when:
            // - All characters matched so far (no mismatch found)
            // - str1 is longer than str2
            if (j == str2.length() && str1.length() > str2.length()) {
                return false;
            }
        }
        return true;
    }
}