package programs.arrays.easy;

/**
 * FindElementInArray
 * This program searches for a given element in an array
 * and returns its index if found, otherwise -1.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class FindElementInArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int key = 6;

        int index = findNumber(arr, key);

        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found");
        }
    }

    public static int findNumber(int[] arr, int key) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
}