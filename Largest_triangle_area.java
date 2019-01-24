/*
  Problem at : https://leetcode.com/problems/largest-triangle-area/
*/

class Solution {
    public double largestTriangleArea(int[][] p) {
        double res = 0;
        for (int i = p.length - 1; i >= 0; --i)
            for (int j = i - 1; j >= 0; --j)
                for (int k = j - 1; k >= 0; --k)
            res = Math.max(res, 0.5 * Math.abs(p[i][0] * p[j][1] + p[j][0] * p[k][1] + p[k][0] * p[i][1]- p[j][0] * p[i][1] - p[k][0] * p[j][1] - p[i][0] * p[k][1]));
        return res;
    }
}


