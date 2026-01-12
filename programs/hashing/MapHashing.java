package programs.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Program to count the frequency of elements in an array using HashMap.
 * - HashMap is used because insertion order does not matter.
 * - It efficiently handles large datasets.
 * - It supports negative values and a wide range of keys.
 * - HashMap provides average O(1) time complexity for put() and get().
 * Note:
 * - Map.Entry<K, V> is used while iterating the result because
 *   it allows direct access to both key and value without
 *   performing an additional lookup.
 */
public class MapHashing {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = input.nextInt();

        // Validate array size
        if (n <= 0) {
            System.out.println("Invalid array size. Exiting program.");
            input.close();
            return;
        }

        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        System.out.println("Entered array: " + Arrays.toString(arr));
        countFrequencyUsingMap(arr);

        input.close();
    }

    /**
     * Counts frequency of each element using HashMap.
     */
    public static void countFrequencyUsingMap(int[] arr) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int element : arr) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
        }

        System.out.println("Frequency Count:");
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}