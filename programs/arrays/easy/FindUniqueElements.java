package programs.arrays.easy;

import java.util.Arrays;

/**
 * Find number of unique elements in a sorted array.
 * The first k positions of the array will contain the unique elements.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class FindUniqueElements {

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 2, 3, 4, 4, 5, 5};

        int k = findUniqueElementsCount(arr);

        System.out.println("Unique count: " + k);
        System.out.println("Unique elements: " +
                Arrays.toString(Arrays.copyOfRange(arr, 0, k)));
    }

    public static int findUniqueElementsCount(int[] arr) {
        if (arr.length == 0) return 0;

        int k = 1; // index for placing next unique element

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[k++] = arr[i];
            }
        }
        return k;
    }
}