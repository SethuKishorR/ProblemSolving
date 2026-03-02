package programs.arrays.medium;

/**
 * Problem:
 * Find the contiguous subarray with the maximum sum.
 * Approach: Kadane’s Algorithm
 * 1. Maintain a running sum (currentSum).
 * 2. At each element, decide whether to:
 *    - Start a new subarray
 *    - Continue the existing subarray
 * 3. Track the maximum sum found so far.
 * Time Complexity  : O(n)
 * Space Complexity : O(1)
 */
public class MaximumSubArray {

    public static void main(String[] args) {
        int[] arr = {5, -10, 2, 3, -1, 5, -10};

        int result = maxSubArray(arr);
        System.out.println("Maximum Subarray Sum: " + result);
    }

    public static int maxSubArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int currentSum = arr[0];
        int maxSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}