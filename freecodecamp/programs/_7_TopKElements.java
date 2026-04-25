package freecodecamp.programs;

import java.util.*;

public class _7_TopKElements {
    /*
     * Leetcode Link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
     * Problem:
     *  Top K Frequent Elements
     * Approach: HashMap + Min Heap (PriorityQueue)
     *
     * Time Complexity: O(n log k)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] nums = {
                1,1,1,1,1,1,1,1,
                2,2,2,
                3,3,
                4,4,4,4,4,4,
                5,5
        };
        int k = 3;

        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

    public static int[] topKFrequent(int[] nums, int k) {

        // Step 1: Build frequency map
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min heap based on frequency
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> freqMap.get(a) - freqMap.get(b));

        // Step 3: Keep only top K elements
        for (int key : freqMap.keySet()) {
            pq.offer(key);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Step 4: Build result
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll();
        }

        return result;
    }
}