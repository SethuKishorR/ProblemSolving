package programs.arrays.easy;

/**
 * Problem:
 * Given a binary array (containing only 0s and 1s),
 * find the maximum number of consecutive 1s.
 * Example:
 * Input  : {1,1,1,0,1,0,1,0,1,1,1,1,1,1,1}
 * Output : 7
 * Approach:
 * Count consecutive 1s.
 * When a 0 is encountered, update max and reset counter.
 * After the loop, perform one final comparison.
 * Time Complexity  : O(n)
 * Space Complexity : O(1)
 */
public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1};
        System.out.println("Maximum Consecutive Ones: " + maxConsecutiveOnes(arr));
    }

    public static int maxConsecutiveOnes(int[] arr) {
        int counter = 0;
        int max = 0;

        for (int num : arr) {
            if (num == 0) {
                max = Math.max(max, counter);
                counter = 0;
            } else {
                counter++;
            }
        }

        // Final check in case array ends with 1s
        return Math.max(counter, max);
    }
}