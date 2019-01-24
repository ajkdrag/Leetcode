/*
  Problem at : https://leetcode.com/problems/construct-quad-tree/
*/

class Solution {
    public Node construct(int[][] grid) {
        return buildTree(grid, 0, 0, grid.length);
    }
    
    private Node buildTree(int[][] grid, int x, int y, int len){
        if(len <= 0) return null;

        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                if(grid[x + i][y + j] != grid[x][y]){
                    return new Node(true, false,
                                    buildTree(grid, x, y, len / 2),
                                    buildTree(grid, x, y + len / 2, len / 2),
                                    buildTree(grid, x + len / 2, y, len / 2),
                                    buildTree(grid, x + len / 2, y + len / 2, len / 2));                                  
                }
            }
        }
        return new Node(grid[x][y] == 1, true, null, null, null, null);
    }
}


