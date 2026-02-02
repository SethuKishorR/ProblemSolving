package programs.sorting.quick;

import java.util.Arrays;

/**
 * Quick Sort implementation
 * Idea:
 * - Choose a pivot element
 * - Place the pivot at its correct sorted position
 * - Move all smaller elements to the left of pivot
 * - Move all greater elements to the right of pivot
 * - Recursively apply the same logic to left and right sub-arrays
 * Algorithm Type:
 * - Divide and Conquer
 * Time Complexity:
 * - Best Case:    O(n log n)
 * - Average Case: O(n log n)
 * - Worst Case:   O(n^2)  (when pivot selection is poor)
 * Space Complexity:
 * - O(log n) (recursion stack)
 * Properties:
 * - Not stable
 * - In-place sorting algorithm
 * Best Use Case:
 * - Large datasets
 * - When average-case performance matters
 * - Faster in practice compared to Merge Sort
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {4, 3, 7, 2, 1, 6, 9, 5, 8};

        System.out.println("Before sorting: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("After sorting:  " + Arrays.toString(arr));
    }

    /**
     * Recursively sorts the array using Quick Sort
     */
    public static void quickSort(int[] arr, int start, int end) {

        // Base condition
        if (start < end) {

            // Partition the array and get pivot index
            int pivotIndex = partition(arr, start, end);

            // Recursively sort left sub-array
            quickSort(arr, start, pivotIndex - 1);

            // Recursively sort right sub-array
            quickSort(arr, pivotIndex + 1, end);
        }
    }

    /**
     * Partitions the array using the first element as pivot
     * and places the pivot at its correct position
     */
    public static int partition(int[] arr, int start, int end) {

        int pivot = arr[start];
        int i = start;
        int j = end;

        while (i < j) {

            // Move i forward until element greater than pivot is found
            while (i <= end && arr[i] <= pivot) {
                i++;
            }

            // Move j backward until element smaller or equal to pivot is found
            while (arr[j] > pivot) {
                j--;
            }

            // Swap elements at i and j
            if (i < j) {
                swap(arr, i, j);
            }
        }

        // Place pivot at its correct sorted position
        swap(arr, start, j);
        return j;
    }

    /**
     * Swaps two elements in the array
     */
    public static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}