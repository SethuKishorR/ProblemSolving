package programs.hashing.code;

import java.util.HashMap;
import java.util.Map;

/*
 * Program: Find elements with minimum and maximum frequency using HashMap
 *
 * Working:
 * 1. Traverse the array and store frequency of each element in a HashMap.
 * 2. Iterate through the map to track minimum and maximum frequency.
 * 3. Store the corresponding elements for min and max frequencies.
 *
 * Time Complexity  : O(n)
 * Space Complexity : O(n)
 */
public class MinMaxFreqMapHashing {

    public static void main(String[] args) {
        int[] arr = {1,1,2,3,4,5,2,1,3,3,4,5,5};
        minMaxHashing(arr);
    }

    public static void minMaxHashing(int[] arr) {
        // Edge case check
        if (arr == null || arr.length == 0) {
            System.out.println("Array is empty");
            return;
        }

        // Step 1: Count frequency of each element
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Initialize min and max trackers
        int minNumber = -1, minValue = Integer.MAX_VALUE;
        int maxNumber = -1, maxValue = Integer.MIN_VALUE;

        // Step 3: Find min and max frequency elements
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (value < minValue) {
                minValue = value;
                minNumber = key;
            }

            if (value > maxValue) {
                maxValue = value;
                maxNumber = key;
            }
        }

        // Output result
        System.out.println("Max Frequency Element: " + maxNumber + " (" + maxValue + ")");
        System.out.println("Min Frequency Element: " + minNumber + " (" + minValue + ")");
    }
}