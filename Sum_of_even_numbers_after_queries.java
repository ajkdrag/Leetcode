/*
  Problem at : https://leetcode.com/problems/sum-of-even-numbers-after-queries/
  Solution at : https://leetcode.com/problems/sum-of-even-numbers-after-queries/solution/
*/

class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int S = 0;
        for (int x: A)
                S += x*(1 - (x&1));

        int[] ans = new int[queries.length];
        int curr = 0;
        int val = 0;
        int id;

        for (int i = 0; i < queries.length; ++i) {
            val = queries[i][0];
            id = queries[i][1];
            curr = A[id];
            if ((curr&1) == 0) S -= curr;
            A[id] = (curr += val);
            if ((curr&1) == 0) S += curr;
            ans[i] = S;
        }
        return ans;
    }
}


