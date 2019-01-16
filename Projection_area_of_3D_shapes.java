/*
  Problem at : https://leetcode.com/problems/projection-area-of-3d-shapes/
  Solution at : https://leetcode.com/problems/projection-area-of-3d-shapes/solution/
*/

class Solution {
    public int projectionArea(int[][] grid) {
        int N = grid.length;
        int area_1 = 0;
        int area_2 = 0;
        int area_3 = 0;
        
        for(int i = 0; i < N; ++i){
            int max_1 = 0;
            int max_2 = 0;
            for(int j = 0; j < N; ++j){
                int val_1 = grid[i][j];
                int val_2 = grid[j][i];
                if(val_1 != 0)
                    area_3++;
                if(val_1 > max_1)
                    max_1 = val_1;
                if(val_2 > max_2)
                    max_2 = val_2;
            }
            area_1 += max_1;
            area_2 += max_2;
        }
        return area_1 + area_2 + area_3;
    }
}


