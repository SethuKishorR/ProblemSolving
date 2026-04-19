package freecodecamp.programs;

import java.util.Arrays;

public class _6_ProductOfArrayExceptSelf {

    /*
    LeetCode: https://leetcode.com/problems/product-of-array-except-self/

    Problem:
    Given an integer array nums, return an array result such that:
    result[i] = product of all elements of nums except nums[i]

    Constraints:
    - Do NOT use division
    - Must run in O(n) time

    Example:
    Input:  [1, 2, 3, 4]
    Output: [24, 12, 8, 6]

    Approach (Optimal - Prefix & Postfix):
    - Use result array to store prefix products
    - Traverse from left → store product of elements before index
    - Traverse from right → multiply with postfix product

    Time Complexity: O(n)
    Space Complexity: O(1) (excluding output array)
    */

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

        // Expected Output: [24, 12, 8, 6]
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];

        int prefix = 1;

        // Step 1: Store prefix products
        for (int i = 0; i < n; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }

        int postfix = 1;

        // Step 2: Multiply with postfix products
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= postfix;
            postfix *= nums[i];
        }

        return result;
    }
}