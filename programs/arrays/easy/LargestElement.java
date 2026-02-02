package programs.arrays.easy;

/**
 * Find the Largest Element in an Array
 * Problem:
 * - Given an integer array, find and return the largest element.
 * Approach:
 * - Assume the first element is the largest
 * - Traverse the array once
 * - Update the largest value whenever a bigger element is found
 * Algorithm Type:
 * - Linear Search
 * Time Complexity:
 * - Best Case:    O(n)
 * - Average Case: O(n)
 * - Worst Case:   O(n)
 * Space Complexity:
 * - O(1) (no extra space used)
 * Properties:
 * - Simple and efficient
 * - Works with duplicate values
 * Best Use Case:
 * - Basic array traversal problems
 * - Interview warm-up questions
 */
public class LargestElement {

    public static void main(String[] args) {

        int[] arr = {5, 2, 1, 5, 7, 9, 10, 3, 2};

        System.out.println("Largest Element is: " + findLargestElement(arr));
    }

    /**
     * Finds the largest element in the given array
     *
     * @param arr input integer array
     * @return largest element in the array
     */
    public static int findLargestElement(int[] arr) {

        // Assume first element is the largest
        int largest = arr[0];

        // Traverse the array
        for (int x : arr) {
            if (x > largest) {
                largest = x;
            }
        }

        return largest;
    }
}