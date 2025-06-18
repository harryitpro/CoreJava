package algorithms.complex;

/**
 * Best Time to Buy and Sell Stock (Max Profit)
 * The goal is to maximize profit by buying at a lower price and selling at a higher price.
 *
 * 1. Problem Statement
 * Given an array prices[] where prices[i] represents the stock price on the i-th day, find the maximum profit by choosing a single buy and single sell.
 *
 * 👉 You must buy before selling.
 *
 * Example
 * Input:  prices = [7, 1, 5, 3, 6, 4]
 * Output: 5
 * Explanation: Buy at **1**, sell at **6** → **Profit = 6 - 1 = 5**
 * Input:  prices = [7, 6, 4, 3, 1]
 * Output: 0
 * Explanation: No profitable transaction possible.

 * 2. Optimized Approach (O(n) Time, O(1) Space)
 * Track the lowest price so far.
 * Calculate profit at each step:
 * profit = current_price - min_price_so_far
 * Keep track of the maximum profit.
 */
public class DynamicProgramming_MaxProfitStock {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price); // Update minimum price
            maxProfit = Math.max(maxProfit, price - minPrice); // Update max profit
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit: " + maxProfit(prices)); // Output: 5
    }
}

