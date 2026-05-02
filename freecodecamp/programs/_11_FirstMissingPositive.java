package freecodecamp.programs;

public class _11_FirstMissingPositive {
    /*
    Leetcode Link: https://leetcode.com/problems/first-missing-positive/

    Problem:
    Given an unsorted integer array nums,
    return the smallest missing positive integer.

    You must implement an algorithm that runs in O(n) time
    and uses O(1) auxiliary space.

    Example:
    Input: nums = [3, 4, -1, 1]
    Output: 2

    Explanation:
    The numbers present are [1, 3, 4]
    The smallest missing positive number is 2.

    ------------------------------------------------------

    Approach (Optimized - Cyclic Sort / Index Placement):

    Idea:
    - Place each number in its correct position.
    - A number x should be placed at index (x - 1)

    Steps:
    1. Iterate through the array
       → For each element:
           - If it is in range [1, n]
           - And not already in correct position
           - Swap it to its correct index

    2. After placement:
       → Traverse array again
       → First index i where nums[i] != i + 1
         → Missing number = i + 1

    3. If all positions are correct:
       → Return n + 1

    ------------------------------------------------------

    Example Walkthrough:
    nums = [3, 4, -1, 1]

    After placement:
    [1, -1, 3, 4]

    Now check:
    index 0 → 1 ✔
    index 1 → should be 2 ❌ → answer = 2

    ------------------------------------------------------

    Time Complexity: O(n)
    - Each element is swapped at most once

    Space Complexity: O(1)
    - In-place algorithm (no extra data structures)
    */

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};

        // Expected Output: 2
        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {

        int n = nums.length;

        // Step 1: Place numbers in correct positions
        for (int i = 0; i < n; i++) {
            // Why are we using a while loop here instead of an if check?
            // Since we are swapping the element, the previous condition applies only to the original nums[i].
            // After swapping, a new element is placed at nums[i], so we need to check it again.
            // This ensures we continue processing until the correct element is placed at the current index.
            // This does not result in O(n^2) operations because each swap places at least one element in its correct position.
            while (
                    nums[i] > 0 &&                 // Ignore negatives & 0
                            nums[i] <= n &&                // Ignore values > n
                            nums[nums[i] - 1] != nums[i]   // Avoid infinite swaps (duplicates)
            ) {
                int correctIndex = nums[i] - 1;

                // Swap
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }

        // Step 2: Find first missing positive
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // Step 3: If all positions are correct
        return n + 1;
    }
}