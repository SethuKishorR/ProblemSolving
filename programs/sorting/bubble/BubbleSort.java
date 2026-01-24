package programs.sorting.bubble;

import java.util.Arrays;

/**
 * Bubble Sort implementation
 * Idea:
 * - Repeatedly compare adjacent elements
 * - Swap if they are in the wrong order
 * - After each pass, the largest element moves to the end
 * Optimizations:
 * 1) Reduce inner loop range since last elements get sorted
 * 2) Stop early if no swaps occur (already sorted)
 * Time Complexity:
 * - Best Case: O(n)  (already sorted)
 * - Average:  O(n²)
 * - Worst:    O(n²)
 * Space Complexity:
 * - O(1) (in-place sorting)
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};

        System.out.println("Before sorting: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("After sorting: " + Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        // Outer loop controls number of passes
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false; // To detect if any swap happened

            // Inner loop bubbles the largest element to the end
            // After each pass, last 'i' elements are already sorted
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    // Swap adjacent elements
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swapped = true;
                }
            }

            // If no swaps occurred, array is already sorted
            if (!swapped) {
                break;
            }
        }
    }
}