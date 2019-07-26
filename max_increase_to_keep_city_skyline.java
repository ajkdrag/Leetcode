/*
  Problem at : https://leetcode.com/problems/max-increase-to-keep-city-skyline/
*/

class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] max_c = new int[n];
        int[] max_r = new int[n];
        for(int i = 0; i < n; ++i){
            int r_max = -1;
            int c_max = -1;
            for(int j = 0; j < n; ++j){
                int curr_c = grid[i][j];
                int curr_r = grid[j][i];
                r_max = curr_c > r_max ? curr_c : r_max;
                c_max = curr_r > c_max ? curr_r : c_max;
            }
            max_r[i] = c_max;
            max_c[i] = r_max;
        }
        int result = 0;
        for(int i = 0; i < n; ++i){
            int val1 = max_r[i];
            for(int j = 0; j < n; ++j){
                int val2 = max_c[j];
                result += (val1 < val2 ? val1 : val2)-grid[i][j];
            }
        }
        return result;
    }
}


