package programs.arrays.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * -----------------------------------------------------------------------------
 * Problem: Find the element that appears only once in an array
 * -----------------------------------------------------------------------------
 * Given an integer array where every element appears multiple times
 * except one element that appears exactly once,
 * return that single element.
 * Implemented Approaches:
 * 1️⃣ Frequency Array (Your Approach)
 *    - Time Complexity  : O(n)
 *    - Space Complexity : O(maxValue)
 *    - Works only for non-negative integers.
 * 2️⃣ HashMap
 *    - Time Complexity  : O(n)
 *    - Space Complexity : O(n)
 *    - Works for negative & large numbers.
 * 3️⃣ XOR (Bit Manipulation)
 *    - Time Complexity  : O(n)
 *    - Space Complexity : O(1)
 *    - Works ONLY if every element appears exactly twice except one.
 */

public class FindSingleAppearance {

    public static void main(String[] args) {

        int[] arr = {1,2,1,3,2,1,2,4,5,4,5,6,6,3,100};

        System.out.println("Frequency Array: " + findUsingFrequencyArray(arr));
        System.out.println("HashMap: " + findUsingHashMap(arr));

        // Valid XOR example (all numbers appear twice except one)
        int[] xorExample = {4,1,2,1,2};
        System.out.println("XOR (valid case): " + findUsingXOR(xorExample));
    }

    /**
     * 1️⃣ Frequency Array Approach (Your Original Logic)
     */
    public static int findUsingFrequencyArray(int[] arr) {

        int max = 0;
        for (int i : arr) {
            max = Math.max(max, i);
        }

        int[] newArr = new int[max + 1];

        for (int i : arr) {
            newArr[i]++;
        }

        for (int i = 0; i < newArr.length; i++) {
            if (newArr[i] == 1) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 2️⃣ HashMap Approach
     */
    public static int findUsingHashMap(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return -1;
    }

    /**
     * 3️⃣ XOR Approach
     * Works only when every element appears exactly twice except one.
     */
    public static int findUsingXOR(int[] arr) {

        int xor = 0;

        for (int num : arr) {
            xor ^= num;
        }

        return xor;
    }
}