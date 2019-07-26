/*
  Problem at : https://leetcode.com/problems/unique-paths-iii/
*/

class Solution {
    int res = 0;
    int startX = -1;
    int startY = -1;
    int targetX = -1;
    int targetY = -1;
    int rows = -1;
    int cols = -1;
    int target = 0;
    int[] dirX = {1, -1, 0, 0};
    int[] dirY = {0, 0, 1, -1};
    int[][] visited;
    int[][] grid;
    
    public int uniquePathsIII(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        visited = new int[rows][cols];
        this.grid = grid;
        for(int i = 0; i < rows; ++i){
            for(int j = 0; j < cols; ++j){
                int val = grid[i][j];
                if(val == 1){
                    startX = i;
                    startY = j;
                }
                else if(val == 2){
                    targetX = i;
                    targetY = j;
                }
                else if(val == 0)
                    ++target;
            }
        }
        visited[startX][startY] = 1;
        dfs(startX, startY, 0);
        return res;
    }
    
    void dfs(int startX, int startY, int soFar){
        if(startX == targetX && startY == targetY){
            if(soFar == target)
                ++res;
        return;
        }
        for(int i = 0; i < 4; ++i){
            int newX = startX + dirX[i];
            int newY = startY + dirY[i];
            if(newX >= 0 && newY >= 0 && newX < rows && newY < cols 
               && visited[newX][newY] == 0 && grid[newX][newY] != -1){
                visited[newX][newY] = 1;
                dfs(newX, newY, soFar + (grid[startX][startY] == 0 ? 1 : 0));
                visited[newX][newY] = 0;
            }
        }
    }
}


