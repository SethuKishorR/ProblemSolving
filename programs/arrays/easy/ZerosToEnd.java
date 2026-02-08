package programs.arrays.easy;

import java.util.Arrays;

/**
 * Move all zeros to the end of the array while preserving
 * the relative order of non-zero elements.
 * Approach:
 * - Use a pointer 'k' to track the index where the next non-zero
 *   element should be placed.
 * - Traverse the array:
 *     - If the current element is non-zero, place it at arr[k]
 *       and increment k.
 * - After traversal, all non-zero elements are placed at the front.
 * - Fill the remaining indices from k to end with zero.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class ZerosToEnd {

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 0, 5, 0, 6, 7, 0, 8, 9};

        moveZeros(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void moveZeros(int[] arr) {
        int k = 0; // index to place the next non-zero element

        // Move non-zero elements to the front
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[k++] = arr[i];
            }
        }

        // Fill remaining positions with zero
        while (k < arr.length) {
            arr[k++] = 0;
        }
    }
}