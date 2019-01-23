/*
  Problem at : https://leetcode.com/problems/surface-area-of-3d-shapes/
*/

class Solution {
    public int surfaceArea(int[][] grid) {
        int total = 0;
        int addend = 0;
        int N = grid.length;
        for(int i = 0; i < N; ++i){
            for(int j = 0; j < N; ++j){
                int val = grid[i][j];
                if(val == 0)
                    continue;
                total += val;
                addend++;
                if(j < N - 1)
                    addend -= val > grid[i][j + 1] ? grid[i][j + 1] : val;
                if(i < N - 1)
                    addend -= val > grid[i + 1][j] ? grid[i + 1][j] : val;
            }
        }
        return (total<<2) + (addend<<1);
    }
}


