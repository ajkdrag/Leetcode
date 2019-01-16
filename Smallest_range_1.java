/*
  Problem at : https://leetcode.com/problems/smallest-range-i/
*/

class Solution {
    public int smallestRangeI(int[] A, int K) {
        int s = A[0];
        int l = A[0];
        int N = A.length;
        if(N == 1)
            return 0;
        for(int i = 1; i < N; ++i){
            int val = A[i];
            if(val < s)
                s = val;
            if(val > l)
                l = val;
        }
        if(l == s)
            return 0;
        int res = l - s - (K<<1);
        return res >= 0 ? res: 0;
        
    }
}


