/*
  Problem at : https://leetcode.com/problems/decode-ways-ii/submissions/
*/

class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        long MOD = 1000000007;
        long invMod9 = 111111112;
        if(n == 0 || s.charAt(0) == '0')
            return 0;
        long[][] dp = new long[n][2];
        dp[0][0] = s.charAt(0) == '*' ? 9 : 1;
        dp[0][1] = 0;
        for(int i = 1; i < n; ++i){
            char curr = s.charAt(i);
            char prevCh = s.charAt(i-1);
            if(curr == '*'){
                dp[i][0] = (9*(dp[i-1][0] + dp[i-1][1]))%MOD;
                if(prevCh == '*'){
                    long base = (dp[i-1][0]*invMod9)%MOD;
                    dp[i][1] = (base*15)%MOD;
                }
                else {
                    int prev = prevCh - '0';
                    if(prev == 1){
                        dp[i][1] = (dp[i-1][0] * 9)%MOD;
                    }
                    else if(prev == 2){
                        dp[i][1] = (dp[i-1][0] * 6)%MOD;
                    }
                    else dp[i][1] = 0;
                }
            }
            else {
                int num = curr - '0';
                dp[i][0] = (num >= 1 ? (dp[i-1][0] + dp[i-1][1])%MOD : 0);
                if(prevCh == '*'){
                    long base = (dp[i-1][0]*invMod9)%MOD;
                    dp[i][1] = (base + (num <= 6 ? base : 0))%MOD;
                }
                else {
                    int prev = prevCh - '0';
                    dp[i][1] = (prev*10 + num) <= 26 ? dp[i-1][0] : 0;
                }
            }
        }
        return (int)((dp[n-1][0] + dp[n-1][1])%MOD);
    }
}

