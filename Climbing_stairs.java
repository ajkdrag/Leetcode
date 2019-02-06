/*
  Problem at : https://leetcode.com/problems/climbing-stairs
*/

class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        if(n <= 3)
            return n;
        int a = 1;
        int b = 2;
        int temp = 0;
        for(int i = 3; i <= n; ++i){
            temp = b;
            b += a;
            a = temp;
        }
        return b;
    }
}


