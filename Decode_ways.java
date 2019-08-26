/*
  Problem at : 
*/

// dp[i][0] = number of ways to decode till 'i' if 'i'th character occurs alone
// dp[i][1] = number of ways to decode till 'i' if 'i'th character occurs in conjunction with previous i.e (i - 1)th character.

class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(n == 0 || s.charAt(0) == '0')
            return 0;
        int[][] dp = new int[n][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        for(int i = 1; i < n; ++i){
            int num = s.charAt(i) - '0';
            int prev = s.charAt(i-1) - '0';
            dp[i][0] = (num >= 1 ? dp[i-1][0] + dp[i-1][1] : 0);
            dp[i][1] = (prev*10 + num) <= 26 ? dp[i-1][0] : 0;
        }
        return dp[n-1][0] + dp[n-1][1];
    }
}
