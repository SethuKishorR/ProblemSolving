package programs.arrays.easy;

/**
 * Second-Largest Element in an Array
 * Idea:
 * - Traverse the array once
 * - Keep track of the largest and second-largest elements
 * Algorithm Type:
 * - Iterative comparison
 * Time Complexity:
 * - Best Case:    O(n)
 * - Average Case: O(n)
 * - Worst Case:   O(n)
 * Space Complexity:
 * - O(1) (constant extra space)
 * Properties:
 * - Single pass solution
 * - Handles duplicate values
 * Best Use Case:
 * - When sorting is not allowed or unnecessary
 * - Interview-friendly optimal solution
 */
public class SecondLargestElement {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Second Largest element in an Array is: " + findSecondLargestElement(arr));
    }

    /**
     * Finds the second-largest element in the array
     */
    public static int findSecondLargestElement(int[] arr) {

        // Assumption: array has at least one element
        int largest = arr[0];
        int secondLargest = Integer.MIN_VALUE;

        // Start from index 1 since arr[0] is already considered
        for (int i = 1; i < arr.length; i++) {

            // Case 1: New largest element found
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            }
            // Case 2: Candidate for second largest (must be < largest)
            else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }

        return secondLargest;
    }
}