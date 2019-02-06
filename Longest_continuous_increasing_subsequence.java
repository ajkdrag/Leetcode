/*
  Problem at : https://leetcode.com/problems/longest-continuous-increasing-subsequence/
*/

class Solution {
    public int findLengthOfLCIS(int[] a) {
        int res = 1;
        int max = 0;
        int len = a.length;
        if(len == 0)
            return max;
        for(int i = 1; i < len; ++i){
            if(a[i] > a[i - 1])
                ++res;
            else{
                max = res > max ? res : max;
                res = 1;
            }
        }
        return res > max ? res : max;
    }
}


