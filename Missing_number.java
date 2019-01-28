/*
  Problem at : https://leetcode.com/problems/missing-number/
*/

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int res = (n*(n + 1))>>1;
        for(int el : nums)
            res -= el;
        return res;
    }
}


