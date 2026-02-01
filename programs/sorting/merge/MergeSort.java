package programs.sorting.merge;

import java.util.Arrays;

/**
 * Merge Sort implementation
 * Idea:
 * - Divide the array into two halves
 * - Recursively sort both halves
 * - Merge the two sorted halves into one sorted array
 * Algorithm Type:
 * - Divide and Conquer
 * Time Complexity:
 * - Best Case:    O(n log n)
 * - Average Case: O(n log n)
 * - Worst Case:   O(n log n)
 * Space Complexity:
 * - O(n) (uses extra arrays for merging)
 * Properties:
 * - Stable sorting algorithm
 * - Not in-place
 * Best Use Case:
 * - Large datasets
 * - When guaranteed performance is required
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {2, 6, 4, 8, 3, 5, 8, 3, 2, 6, 8, 3, 2};

        System.out.println("Before sorting: " + Arrays.toString(arr));
        arr = mergeSort(arr);
        System.out.println("After sorting:  " + Arrays.toString(arr));
    }

    /**
     * Recursively splits the array and merges sorted halves
     */
    public static int[] mergeSort(int[] arr) {

        // Base case: single element is already sorted
        if (arr.length <= 1) {
            return arr;
        }

        int mid = arr.length / 2;

        // Split array into two halves
        int[] leftArray = Arrays.copyOfRange(arr, 0, mid);
        int[] rightArray = Arrays.copyOfRange(arr, mid, arr.length);

//        Manual copy:
//        int[] left = new int[mid];
//        int[] right = new int[arr.length - mid];
//
//        // manual copy
//        for (int i = 0; i < mid; i++) {
//            left[i] = arr[i];
//        }
//        for (int i = mid; i < arr.length; i++) {
//            right[i - mid] = arr[i];
//        }

        // Recursively sort both halves
        leftArray = mergeSort(leftArray);
        rightArray = mergeSort(rightArray);

        // Merge sorted halves
        return merge(leftArray, rightArray);
    }

    /**
     * Merges two sorted arrays into one sorted array
     */
    public static int[] merge(int[] leftArray, int[] rightArray) {

        int[] result = new int[leftArray.length + rightArray.length];
        int i = 0, j = 0, k = 0;

        // Compare elements and merge in sorted order
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                result[k++] = leftArray[i++];
            } else {
                result[k++] = rightArray[j++];
            }
        }

        // Copy remaining elements (if any)
        while (i < leftArray.length) {
            result[k++] = leftArray[i++];
        }

        while (j < rightArray.length) {
            result[k++] = rightArray[j++];
        }

        return result;
    }
}