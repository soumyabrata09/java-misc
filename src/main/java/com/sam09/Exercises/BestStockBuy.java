/**
 * Best Time to Buy and Sell Stock
 * Junior
 *
 * Companies
 * You have an array of prices where each element prices[i] represents the price of a stock on day i. You want to choose exactly one day to buy the stock and another (later) day to sell it in order to maximize your profit.
 * Your task is to return the maximum possible profit. If no profit can be made, return 0.
 * Example 1:
 * Input: prices = [8, 2, 5, 4, 11, 1]
 * Output: 9
 * Explanation:
 * The best strategy is to buy on day 2 (price = 2) and sell on day 5 (price = 11),
 * resulting in a profit of 11−2=9.
 * Example 2:
 * Input: prices = [5, 4, 3, 2, 1]
 * Output: 0
 * Explanation:
 * The prices only go down each day, so there is no chance to make a profit.
 * Hence, the maximum profit is 0.
 * Constraints:
 * 1 <= prices.length <= 10⁵
 * 0 <= prices[i] <= 10⁵
 */

package com.sam09.Exercises;

public class BestStockBuy {

    public int maxProfit(int[] prices) {
        var left = 0;
        var result = 0;

        for (var right = 0; right < prices.length; right++) {
            result = Math.max(result, prices[right] - prices[left]);

            if (prices[right] < prices[left]) {
                left = right;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        var prices = new int[] {8, 2, 5, 4, 11, 1};
        var prices2 = new int[] {5, 4, 3, 2, 1};

        var obj = new BestStockBuy();
        System.out.println("Maximum profit: " + obj.maxProfit(prices));
        System.out.println("Maximum profit: " + obj.maxProfit(prices2));
    }
}
