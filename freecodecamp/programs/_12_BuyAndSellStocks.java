package freecodecamp.programs;

public class _12_BuyAndSellStocks {
    /*
    Leetcode Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

    Problem:
    You are given an array where prices[i] is the price of a given stock on the ith day.
    You want to maximize your profit by choosing a single day to buy one stock
    and choosing a different day in the future to sell that stock.

    Return the maximum profit you can achieve.
    If no profit is possible, return 0.

    Example:
    Input: prices = [4,5,1,2,3,6,4,0,3]
    Output: 5
    Explanation:
    Buy at price 1 and sell at price 6 → Profit = 6 - 1 = 5

    Approach (Optimized - One Pass):
    - Track the minimum price seen so far
    - For each price:
        → Update minPrice if current price is smaller
        → Calculate profit = current price - minPrice
        → Update maxProfit if this profit is greater

    Time Complexity: O(n)
    Space Complexity: O(1)
    */

    public static void main(String[] args) {
        int[] nums = {4, 5, 1, 2, 3, 6, 4, 0, 3};

        // Expected Output: 5
        System.out.println(profit(nums));
    }

    public static int profit(int[] nums) {
        int minPrice = Integer.MAX_VALUE; // Track lowest price so far
        int maxProfit = 0; // Track maximum profit

        for (int price : nums) {

            // Update minimum price
            minPrice = Math.min(minPrice, price);

            // Calculate profit if sold today
            int currentProfit = price - minPrice;

            // Update maximum profit
            maxProfit = Math.max(maxProfit, currentProfit);
        }

        return maxProfit;
    }
}