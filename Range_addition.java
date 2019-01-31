/*
  Problem at : https://leetcode.com/problems/range-addition-ii/
  Solution at : https://leetcode.com/problems/range-addition-ii/solution/
*/

public class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        for (int[] op: ops) {
            m = Math.min(m, op[0]);
            n = Math.min(n, op[1]);
        }
        return m * n;
    }
}


