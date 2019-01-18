/*
  Problem at : https://leetcode.com/problems/toeplitz-matrix/
*/

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int n = matrix[0].length;
        int m = matrix.length;
        for(int j = 0; j < m - 1; ++j){
            for(int i = 0; i < n - 1; ++i){
                if(matrix[j][i] != matrix[j+1][i+1])
                    return false;
            }
        }
        return true;
    }
}


