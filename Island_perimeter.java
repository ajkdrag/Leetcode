/*
  Problem at : https://leetcode.com/problems/island-perimeter/
*/

class Solution {
    public int islandPerimeter(int[][] grid) {
        int toSub = 0;
        int total = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(grid[i][j] == 1){
                    ++total;
                    if(j < n - 1 && grid[i][j + 1] == 1){
                        ++toSub;
                    }
                    if(i < m - 1 && grid[i + 1][j] == 1){
                        ++toSub;
                    }
                }
            }
        }
        return (total<<2)-(toSub<<1);
    }
}


