package programs.sorting.insertion;

import java.util.Arrays;

/**
 * Insertion Sort implementation
 * Idea:
 * - Divide the array into sorted and unsorted parts
 * - Assume the first element is already sorted
 * - Pick the next element (key) from the unsorted part
 * - Shift elements in the sorted part to the right
 * - Insert the key at its correct position
 * Time Complexity:
 * - Best Case: O(n)   (already sorted)
 * - Average: O(n²)
 * - Worst: O(n²)
 * Space Complexity:
 * - O(1) (in-place sorting)
 * Best Use Case:
 * - Works well for small datasets
 * - Efficient when array is nearly sorted
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {1, 0, 7, 9, 2, 4, 6, 8, 5};

        System.out.println("Before sorting: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("After sorting: " + Arrays.toString(arr));
    }

    public static void sort(int[] arr) {

        // Start from index 1 since index 0 is considered sorted
        for (int i = 1; i < arr.length; i++) {
            // Element to be inserted into the sorted part
            int key = arr[i];
            // Start comparing from the previous index
            int j = i - 1;
            // Shift elements greater than key to the right
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            // Insert key at the correct position
            arr[j + 1] = key;
        }
    }
}