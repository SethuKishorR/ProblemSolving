package programs.arrays.easy;

/**
 * Problem:
 * Find the length of the longest subarray with sum equal to k.
 * Example:
 * Input  : {10, 5, 2, 7, 1, 9}
 * k = 15
 * Output : 4
 * Explanation:
 * The longest subarray is {5, 2, 7, 1}
 * Approach (Sliding Window):
 * - Use two pointers (i, j).
 * - Expand window by increasing j and adding arr[j] to sum.
 * - If sum exceeds k, shrink window from left (increment i).
 * - If sum equals k, update max length.
 * Note:
 * This approach works ONLY when array contains positive numbers.
 * Time Complexity  : O(n)
 * Space Complexity : O(1)
 */
public class LongestSubArray {

    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, 9};
        int k = 15;

        System.out.println("Length of longest subarray with sum " + k + " is: "
                + longestSubArray(arr, k));
    }

    public static int longestSubArray(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int i = 0;
        int sum = 0;
        int maxLength = 0;

        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];

            // Shrink window if sum exceeds k
            while (i <= j && sum > k) {
                sum -= arr[i];
                i++;
            }

            // Check if sum equals k
            if (sum == k) {
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }

        return maxLength;
    }
}