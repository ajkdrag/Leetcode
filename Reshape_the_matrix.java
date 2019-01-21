/*
  Problem at : https://leetcode.com/problems/reshape-the-matrix/
*/

class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums[0].length;
        int n = nums.length;
        if(nums.length==0||m==0||r*c != m*n) return nums;
        int[][] res = new int[r][c];
        for(int i = 0; i < r*c; i++) {
            res[i/c][i%c] = nums[i/m][i%m];
        }
        return res;
    }
}


