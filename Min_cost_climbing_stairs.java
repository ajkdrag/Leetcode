/*
  Problem at : https://leetcode.com/problems/min-cost-climbing-stairs/
*/

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int i = 2;
        for( ; i < cost.length; ++i){
            cost[i] = Math.min(cost[i-1], cost[i-2]) + cost[i];
        }
        return cost[i-1] < cost[i -2] ? cost[i-1] : cost[i - 2];
    }
}

