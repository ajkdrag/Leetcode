/*
  Problem at : https://leetcode.com/problems/house-robber/
*/

class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 0)
            return 0;
        if(len == 1)
            return nums[0];
        nums[1] = nums[0] > nums[1] ? nums[0] : nums[1];
        for(int i = 2; i < len; ++i){
            nums[i] = Math.max(nums[i-1], nums[i] + nums[i - 2]);
        }
        return nums[len - 1];
    }
}


