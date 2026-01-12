package programs.hashing.code;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Program to count frequency of lowercase alphabets using array hashing.
 * Assumption:
 * - Input characters are lowercase letters (a–z).
 * - Uses array index mapping: 'a' → 0, 'b' → 1, ..., 'z' → 25
 * Time Complexity: O(n)
 * Space Complexity: O(1) (fixed size array of 26)
 */
public class AlphabetArrayHashing {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter array size: ");
        int n = input.nextInt();

        // Validate array size
        if (n <= 0) {
            System.out.println("Invalid array size. Exiting program.");
            return;
        }

        char[] arr = new char[n];
        System.out.println("Enter characters (a-z): ");
        for (int i = 0; i < n; i++) {
            arr[i] = input.next().charAt(0);
        }

        System.out.println("Entered array: " + Arrays.toString(arr));
        countFrequencyUsingArray(arr);

        input.close();
    }

    public static void countFrequencyUsingArray(char[] arr) {
        int[] count = new int[26];

        for (char c : arr) {
            // Convert character to index (a → 0, b → 1, ..., z → 25)
            count[c - 'a']++;
        }

        System.out.println("Character frequencies:");
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                System.out.println((char) (i + 'a') + " : " + count[i]);
            }
        }
    }
}