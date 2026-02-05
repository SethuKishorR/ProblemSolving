package programs.arrays.easy;

/**
 * Check if Array is Sorted and Rotated
 * Idea:
 * - A rotated sorted array can have at most one place
 *   where the order breaks (nums[i] > nums[i+1])
 * - Treat the array as circular
 * Time Complexity:
 * - O(n)
 * Space Complexity:
 * - O(1)
 */
public class IsArraySorted {

    public static void main(String[] args) {

        int[] arr = {4,5,6,1,2,3};
        System.out.println(isSortedAndRotated(arr));
    }

    public static boolean isSortedAndRotated(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int next = (i + 1) % n;

            if (nums[i] > nums[next]) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}