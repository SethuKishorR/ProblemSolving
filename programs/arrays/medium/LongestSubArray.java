package programs.arrays.medium;

import java.util.HashMap;

/**
 * Problem:
 * Find the longest substring without repeating characters.
 * Example:
 * Input  : "abcdabcdeabc"
 * Output : Length = 5
 *          Substring = "abcde"
 * Approach (Sliding Window + HashMap):
 * 1. Use two pointers (left and right) to maintain a window.
 * 2. Store the last seen index of each character in a HashMap.
 * 3. If a duplicate character is found within the current window,
 *    move the left pointer to (lastIndex + 1).
 * 4. Update maximum length and starting index accordingly.
 * Time Complexity  : O(n)
 * Space Complexity : O(min(n, charset))
 */
public class LongestSubArray {

    public static void main(String[] args) {
        String str = "abcdabcdeabc";
        findMaxSubArray(str);
    }

    public static void findMaxSubArray(String str) {
        if (str == null || str.isEmpty()) {
            System.out.println("MaxLength: 0");
            return;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLength = 0;
        int startIndex = 0;

        for (int right = 0; right < str.length(); right++) {

            char currentChar = str.charAt(right);

            // If character is already seen and inside current window
            if (map.containsKey(currentChar) && map.get(currentChar) >= left) {
                left = map.get(currentChar) + 1;
            }

            // Update latest index of character
            map.put(currentChar, right);

            // Update maximum length
            int currentLength = right - left + 1;
            if (currentLength > maxLength) {
                maxLength = currentLength;
                startIndex = left;
            }
        }

        System.out.println("MaxLength: " + maxLength);
        System.out.println("SubArray: " + str.substring(startIndex, startIndex + maxLength));
    }
}