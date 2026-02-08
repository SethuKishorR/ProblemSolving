package programs.arrays.easy;

import programs.sorting.quick.QuickSort;
import java.util.Arrays;

/**
 * Rotate an array left or right by n positions using the Reversal Algorithm.
 * Core Idea:
 * - Rotation can be seen as swapping two contiguous blocks of the array.
 * - Reversing blocks preserves internal order while changing their positions.
 * - Left and Right rotations use the SAME three reversals;
 *   only the ORDER of applying them differs.
 * Left Rotation:
 * - Goal: Move the first n elements to the end.
 * Steps:
 * 1) Reverse first n elements
 * 2) Reverse remaining elements
 * 3) Reverse entire array
 * Right Rotation:
 * - Goal: Move the last n elements to the front.
 * Steps:
 * 1) Reverse entire array
 * 2) Reverse first n elements
 * 3) Reverse remaining elements
 * Interview Insight:
 * - Right rotation is the inverse sequence of left rotation reversals.
 * - Same ranges, different order → different rotation direction.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = 2;
        boolean rotateLeft = false;

        rotateArray(arr, n, rotateLeft);
        System.out.println(Arrays.toString(arr));
    }

    public static void rotateArray(int[] arr, int n, boolean rotateLeft) {
        if (arr == null || arr.length == 0) {
            return;
        }

        // Normalize rotation count
        n = n % arr.length;
        if (n == 0) {
            return;
        }

        if (rotateLeft) {
            rotateLeft(arr, n);
        } else {
            rotateRight(arr, n);
        }
    }

    private static void rotateLeft(int[] arr, int n) {
        // Reverse remaining elements
        reverse(arr, n, arr.length - 1);

        // Reverse first n elements
        reverse(arr, 0, n - 1);

        // Reverse whole array
        reverse(arr, 0, arr.length - 1);
    }

    private static void rotateRight(int[] arr, int n) {
        // Reverse whole array
        reverse(arr, 0, arr.length - 1);

        // Reverse first n elements
        reverse(arr, 0, n - 1);

        // Reverse remaining elements
        reverse(arr, n, arr.length - 1);
    }

    private static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            QuickSort.swap(arr, left, right);
            left++;
            right--;
        }
    }
}