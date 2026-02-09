package programs.arrays.easy;

import java.util.Arrays;

/**
 * UnionElements
 * Finds the union of two sorted arrays using the two-pointer technique.
 * Duplicate elements are included only once.
 * Time Complexity: O(n + m)
 * Space Complexity: O(n + m)
 */
public class UnionElements {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        int[] arr2 = {2, 3, 5, 7, 9, 10};

        System.out.println(Arrays.toString(union(arr1, arr2)));
    }

    public static int[] union(int[] arr1, int[] arr2) {

        int i = 0, j = 0, k = 0;
        int n = arr1.length, m = arr2.length;

        int[] result = new int[n + m];

        while (i < n && j < m) {

            int value;
            if (arr1[i] < arr2[j]) {
                value = arr1[i++];
            } else if (arr1[i] > arr2[j]) {
                value = arr2[j++];
            } else {
                value = arr1[i];
                i++;
                j++;
            }

            // Avoid duplicates
            // k == 0 ensures safe insertion when result array is empty
            if (k == 0 || result[k - 1] != value) {
                result[k++] = value;
            }
        }

        while (i < n) {
            if (k == 0 || result[k - 1] != arr1[i]) {
                result[k++] = arr1[i];
            }
            i++;
        }

        while (j < m) {
            if (k == 0 || result[k - 1] != arr2[j]) {
                result[k++] = arr2[j];
            }
            j++;
        }

        return Arrays.copyOf(result, k);
    }
}