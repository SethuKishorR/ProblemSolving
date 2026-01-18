package programs.fibonacci;

import java.util.Scanner;

/**
 * Program to generate Fibonacci numbers using Dynamic Programming.
 * How it works:
 * - Uses an array to store previously computed Fibonacci values.
 * - Each number is the sum of the previous two numbers.
 * - This avoids recomputation and runs in linear time.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Note:
 * - This approach is efficient compared to naive recursion.
 * - Suitable when all Fibonacci values up to N are required.
 */
public class FibonacciArray {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the N value: ");
        int n = input.nextInt();

        if (n < 0) {
            System.out.println("Invalid input. N must be non-negative.");
            return;
        }

        int[] res = fibonacci(n);

        System.out.print("Fibonacci for N numbers are:");
        for (int i : res) {
            System.out.print(" " + i);
        }

        input.close();
    }

    public static int[] fibonacci(int n) {
        // Handle base cases
        if (n == 0) {
            return new int[] {0};
        }

        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;

        // Build Fibonacci sequence bottom-up
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr;
    }
}