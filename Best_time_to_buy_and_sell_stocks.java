/*
  Problem at : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
*/

class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0)
            return 0;
        int min_price = prices[0];
        int max_profit = 0;
        for(int i : prices){
            if(i < min_price){
                min_price = i;
            }
            else {
                max_profit = i - min_price > max_profit ? i - min_price : max_profit;
            }
        }
        return max_profit;
    }
}


