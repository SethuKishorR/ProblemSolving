package programs.sorting.selection;

import java.util.Arrays;

/**
 * Selection Sort implementation.
 * How it works:
 * - Repeatedly finds the minimum element from the unsorted part.
 * - Swaps it with the element at the current position.
 * Characteristics:
 * - Time Complexity: O(n^2)
 * - Space Complexity: O(1)
 * - Not stable
 * - In-place sorting algorithm
 * Best suited for:
 * - Small datasets
 * - Learning sorting fundamentals
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {10, 2, 1, 0, 8, 6, 5, 9, 11};
        sort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;

            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}