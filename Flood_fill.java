/*
  Problem at : https://leetcode.com/problems/flood-fill/
*/

// DFS
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor) dfs(image, sr, sc, color, newColor);
        return image;
    }
    public void dfs(int[][] image, int r, int c, int color, int newColor) {
        if (image[r][c] == color) {
            image[r][c] = newColor;
            if (r >= 1) dfs(image, r-1, c, color, newColor);
            if (c >= 1) dfs(image, r, c-1, color, newColor);
            if (r+1 < image.length) dfs(image, r+1, c, color, newColor);
            if (c+1 < image[0].length) dfs(image, r, c+1, color, newColor);
        }
    }
}

// BFS
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;
        Queue<Integer> q = new LinkedList<>();
        int src = sr*n + sc;
        int srcColor = image[sr][sc];
        if(srcColor == newColor)
            return image;
        q.add(src);
        while(!q.isEmpty()){
            int curr = q.poll();
            int i = curr/n;
            int j = curr%n;
            if(image[i][j] == srcColor){
                image[i][j] = newColor;
                if(i > 0){
                    q.offer(curr - n);
                }
                if(i < m - 1){
                    q.offer(curr + n);
                }
                if(j > 0){
                    q.offer(curr - 1);
                }
                if(j < n - 1){
                    q.offer(curr + 1);
                }
            }
        }
        return image;
    }
}


