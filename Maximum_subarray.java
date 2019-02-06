/*
  Problem at : https://leetcode.com/problems/maximum-subarray/
*/

// kadane's algo
class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        int maxsofar = max;
        for(int i = 1; i < nums.length; ++i){
            int curr = nums[i];
            maxsofar = curr + (maxsofar > 0 ? maxsofar : 0);
            max = maxsofar > max ? maxsofar : max;
        }
        return max;
    }
}


