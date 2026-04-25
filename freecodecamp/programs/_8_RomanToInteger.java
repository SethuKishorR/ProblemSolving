package freecodecamp.programs;

import java.util.Map;

/*
 * Problem: Roman to Integer
 * Link: https://leetcode.com/problems/roman-to-integer/
 *
 * Approach:
 * - Use a map to store Roman numeral values
 * - Traverse the string from left to right
 * - If current value < next value → subtract
 * - Else → add
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class _8_RomanToInteger {
    private static final Map<Character, Integer> ROMAN_MAP = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000);

    public static void main(String[] args) {
        String input = "MCMXCIV";
        int result = romanToInt(input);

        System.out.println("Input  : " + input);
        System.out.println("Output : " + result);
    }

    public static int romanToInt(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            int current = ROMAN_MAP.get(s.charAt(i));
            if (i < s.length() - 1 && current < ROMAN_MAP.get(s.charAt(i + 1))) {
                result -= current;
            } else {
                result += current;
            }
        }
        return result;
    }
}