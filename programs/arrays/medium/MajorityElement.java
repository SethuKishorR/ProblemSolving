package programs.arrays.medium;

/**
 * Problem:
 * Find the majority element (appearing more than n/2 times).
 * Approach: Boyer-Moore Voting Algorithm
 * 1. Find candidate using cancellation.
 * 2. Verify candidate frequency.
 * Time Complexity  : O(n)
 * Space Complexity : O(1)
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] arr = {1,2,1,3,4,4,1,1,1,1,1,3,4};

        int result = findMajorityElement(arr);
        System.out.println("Majority Element: " + result);
    }

    public static int findMajorityElement(int[] arr) {
        int count = 0, candidate = 0;

        // Step 1: Find candidate
        for (int num : arr) {
            if (count == 0) {
                candidate = num;
            }

            if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }

        // Step 2: Verify candidate
        count = 0;
        for (int num : arr) {
            if (num == candidate) {
                count++;
            }
        }

        if (count > arr.length / 2) {
            return candidate;
        }

        return -1;
    }
}
