package freecodecamp.programs;

import java.util.HashSet;

public class _2_ContainsDuplicates {

    /*
    Leetcode Link: https://leetcode.com/problems/contains-duplicate/
    Problem:
    Given an integer array, determine if any value appears at least twice.
    Return true if any duplicate exists, otherwise return false.

    Example:
    Input: arr = [1, 2, 3, 4, 5]
    Output: false

    Input: arr = [1, 2, 3, 1]
    Output: true

    Approach (Optimized - HashSet):
    - Use a HashSet to store elements we have already seen
    - Traverse the array:
        → If element already exists in the set → duplicate found → return true
        → Otherwise, add it to the set
    - If no duplicates found after traversal → return false

    Time Complexity: O(n)
    Space Complexity: O(n)
    */

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 5};

        // Expected Output: false (no duplicates)
        System.out.println(checkForDuplicates(arr));
    }

    public static boolean checkForDuplicates(int[] arr) {

        // HashSet to store seen elements
        HashSet<Integer> seenNumbers = new HashSet<>();

        for (int num : arr) {

            // If number already exists → duplicate found
            if (seenNumbers.contains(num)) {
                return true;
            }

            // Add number to set
            seenNumbers.add(num);
        }

        // No duplicates found
        return false;
    }
}