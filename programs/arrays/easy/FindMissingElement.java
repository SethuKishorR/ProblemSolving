package programs.arrays.easy;

/**
 * Problem:
 * Given an array containing numbers from 1 to N with one missing number,
 * find the missing element.
 * Example:
 * Input  : {1,3,5,7,9,2,4,6,10}
 * Output : 8
 */
public class FindMissingElement {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 2, 4, 6, 10};

        System.out.println(findMissingElementUsingFrequency(arr));
        System.out.println(findMissingElementOptimized(arr));
    }

    /**
     * Approach 1: Frequency Array
     * Time Complexity  : O(n)
     * Space Complexity : O(n)
     */
    public static int findMissingElementUsingFrequency(int[] arr) {
        int n = arr.length + 1;          // total numbers including missing one
        int[] freq = new int[n + 1];     // index range: 0 to n

        for (int num : arr) {
            freq[num]++;
        }

        for (int i = 1; i <= n; i++) {
            if (freq[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Approach 2: Sum Formula (Optimized)
     * Time Complexity  : O(n)
     * Space Complexity : O(1)
     */
    public static int findMissingElementOptimized(int[] arr) {
        int n = arr.length + 1;

        long expectedSum = (long) n * (n + 1) / 2;
        long actualSum = 0;

        for (int num : arr) {
            actualSum += num;
        }

        return (int) (expectedSum - actualSum);
    }
}