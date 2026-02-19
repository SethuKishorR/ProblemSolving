package programs.arrays.medium;

import java.util.Arrays;

/**
 * Problem:
 * Given an array containing only 0s, 1s and 2s,
 * sort the array in-place.
 * Example:
 * Input  : [1, 0, 2, 1, 0]
 * Output : [0, 0, 1, 1, 2]
 * Approach:
 * Dutch National Flag Algorithm (3-pointer technique)
 * Time Complexity  : O(n)
 * Space Complexity : O(1)
 */
public class SortColors {

    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 1, 0};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }

    // If arr[mid] == 0:
    //     Swap with left pointer
    //     Increment both left and mid
    //
    // If arr[mid] == 1:
    //     Just increment mid
    //
    // If arr[mid] == 2:
    //     Swap with right pointer
    //     Decrement right only (do NOT increment mid)
    public static void sortColors(int[] arr) {
        int low = 0, mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            }
            else if (arr[mid] == 1) {
                mid++;
            }
            else { // arr[mid] == 2
                swap(arr, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}