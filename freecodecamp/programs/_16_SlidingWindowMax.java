package freecodecamp.programs;

import java.util.*;

public class _16_SlidingWindowMax {

    /*
    LeetCode:
    https://leetcode.com/problems/sliding-window-maximum/

    Problem:
    Find maximum in each sliding window of size k

    Input:  [1,3,-1,-3,5,3,6,7], k = 3
    Output: [3,3,5,5,6,7]

    Approach (Deque - Monotonic Decreasing Queue):
    - Store indices in deque
    - Maintain decreasing order of values
    - Front always holds max of window

    Time Complexity: O(n)
    Space Complexity: O(k)
    */

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> dq = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {

            // Remove indices out of window
            if (!dq.isEmpty() && dq.peekFirst() == i - k) {
                dq.pollFirst();
            }

            // Maintain decreasing order
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);

            // Store result when window is ready
            if (i >= k - 1 && !dq.isEmpty()) {
                result[index++] = nums[dq.peekFirst()];
            }
        }

        return result;
    }
}