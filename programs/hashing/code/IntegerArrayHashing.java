package programs.hashing.code;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Key Points:
 * 1. First find the maximum value in the array to define the hash array size.
 * 2. The hash array size is (max + 1) because indexing starts from 0.
 * 3. This technique works only for non-negative integers.
 * 4. Array hashing is extremely fast (O(1) lookup time).
 * 5. It consumes more memory and is suitable only for small value ranges.
 * 6. For large datasets or negative values, prefer using HashMap.
 */
public class IntegerArrayHashing {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = input.nextInt();

        // Validate array size
        if (n <= 0) {
            System.out.println("Invalid array size. Exiting program.");
            return;
        }

        int[] arr = new int[n];

        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        System.out.println("Entered array: " + Arrays.toString(arr));
        countFrequencyUsingArray(arr, input);

        input.close();
    }

    /**
     * Counts the frequency of elements using array hashing.
     * Works only for non-negative integers.
     *
     * @param arr   input array
     * @param input Scanner object for user queries
     */
    public static void countFrequencyUsingArray(int[] arr, Scanner input) {

        // Step 1: Find the maximum element to determine hash array size
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }

        // Step 2: Create frequency array (hash array)
        int[] frequency = new int[max + 1];

        // Step 3: Populate frequency array
        for (int num : arr) {
            frequency[num]++;
        }

        // Step 4: Query frequency
        System.out.print("Enter a number to check its frequency: ");
        int query = input.nextInt();

        if (query < 0 || query > max) {
            System.out.println(0);
        } else {
            System.out.println(frequency[query]);
        }
    }
}