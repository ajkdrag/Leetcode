/*
  Problem at : https://leetcode.com/problems/magic-squares-in-grid/
  Solution at : https://leetcode.com/problems/magic-squares-in-grid/discuss/133874/Python-5-and-43816729
  and : https://leetcode.com/problems/magic-squares-in-grid/solution/
*/

class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int res = 0;
        for(int i = 1; i < grid.length -1; i++){
            for(int j = 1; j < grid[0].length-1; j++) {
                if(grid[i][j] == 5)
                    res += isMagic(i, j, grid) ? 1 : 0;
            }
        }
        return res;
    }
    public boolean isMagic(int i, int j, int[][] grid) {
        String s = "" + grid[i-1][j-1] + grid[i-1][j] + grid[i-1][j+1] + grid[i][j+1] +                             grid[i+1][j+1] + grid[i+1][j] + grid[i+1][j-1] + grid[i][j-1];
        return "4381672943816729".contains(s) || "9276183492761834".contains(s);
    }
}


