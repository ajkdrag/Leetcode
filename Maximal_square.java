/*
  Problem at : https://leetcode.com/problems/maximal-square/
*/

class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if(m == 0)
            return 0;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for(int i = 0; i < m; ++i){
            int curr = -'0' + matrix[i][0];
            max |= curr;
            dp[i][0] = curr;
        }
        for(int i = 0; i < n; ++i){
            int curr = -'0' + matrix[0][i];
            max |= curr;
            dp[0][i] = curr;
        }
        
        for(int i = 1; i < m; ++i){
            for(int j = 1; j < n; ++j){
                int curr = matrix[i][j] - '0';
                if(curr == 0)
                    continue;
                int up = dp[i-1][j];
                int left = dp[i][j-1];
                int diag = dp[i-1][j-1];
                int min = (min = up < left ? up : left) < diag ? min : diag;
                if(min > 0)
                    curr = min + 1;
                dp[i][j] = curr;
                max = curr > max ? curr : max;
            }
        }
        return max*max;
    }
}


