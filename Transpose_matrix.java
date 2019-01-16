/*
  Problem at : https://leetcode.com/problems/transpose-matrix/submissions/
*/

class Solution {
    public int[][] transpose(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int[][] t = new int[n][m];
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                t[i][j] = A[j][i];
            }
        }
        return t;
    }
}


