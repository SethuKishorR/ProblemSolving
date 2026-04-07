package freecodecamp.programs;

import java.util.HashMap;
import java.util.Arrays;

public class _1_TwoSum {
    /*
    Leetcode Link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
    Problem:
    Given an array of integers and a target value k,
    return the indices of the two numbers such that they add up to k.

    Example:
    Input: arr = [1, 7, 3, 2], k = 9
    Output: [0, 1]
    Explanation: arr[0] + arr[1] = 1 + 7 = 8 ❌ (not correct)
                 arr[1] + arr[3] = 7 + 2 = 9 ✅ (correct)
                 So output = [1, 3]

    Approach (Optimized - HashMap):
    - Use a HashMap to store value -> index
    - For each element, compute complement = k - current element
    - Check if complement already exists in map
        → If yes, return indices
    - Otherwise, store current element in map

    Time Complexity: O(n)
    Space Complexity: O(n)
    */

    public static void main(String[] args) {
        int[] arr = {1, 7, 3, 2};
        int k = 9;

        // Expected Output: [1, 3]
        System.out.println(Arrays.toString(findTwoSum(arr, k)));
    }

    public static int[] findTwoSum(int[] arr, int k) {

        // HashMap to store value and its index
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            int complement = k - arr[i]; // Find required pair value

            // Check if complement exists in map
            if (map.containsKey(complement)) {

                // Found the pair → return indices
                // map.get(complement) → index of previous element
                // i → current index
                return new int[]{map.get(complement), i};
            }

            // Store current element with its index
            map.put(arr[i], i);
        }

        // If no valid pair found
        return new int[]{-1, -1};
    }
}