package programs.arrays.easy;

import java.util.HashMap;

/**
 * Problem:
 * Find the length of the longest subarray having sum equal to k.
 * Example:
 * Input  : {10, 5, 2, 7, 1, 9}, k = 15
 * Output : 4  (Subarray: {5, 2, 7, 1})
 * Approach (Prefix Sum + HashMap):
 * 1. Maintain a running prefix sum.
 * 2. If prefixSum == k → subarray from 0 to current index.
 * 3. If (prefixSum - k) exists in map,
 *    then subarray exists between (previousIndex + 1) to current index.
 * 4. Store prefixSum in map only if it is not already present
 *    (to keep the earliest index for maximum length).
 * Time Complexity  : O(n)
 * Space Complexity : O(n)
 */
public class LongestSubArrayHashing {

    public static void main(String[] args) {
        int[] arr = {1, 1, 1};
        int k = 3;
        System.out.println("Longest subarray length: " + longestSubArray(arr, k));
    }

    public static int longestSubArray(int[] arr, int k) {
        int sum = 0, max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);  // Important

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (map.containsKey(sum - k)) {
                int length = i - map.get(sum - k);
                max = Math.max(max, length);
            }

            map.putIfAbsent(sum, i); // Store first occurrence only
        }

        return max;
    }
}
