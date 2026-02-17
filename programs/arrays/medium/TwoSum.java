package programs.arrays.medium;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Problem:
 * Given an array and a target,
 * return indices of two numbers such that they add up to target.
 * Time Complexity  : O(n)
 * Space Complexity : O(n)
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 5};
        int k = 10;

        System.out.println("Indices: " + Arrays.toString(twoSum(arr, k)));
    }

    public static int[] twoSum(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int required = k - arr[i];

            if (map.containsKey(required)) {
                return new int[]{map.get(required), i};
            }

            map.put(arr[i], i);
        }

        return new int[]{-1, -1};
    }
}