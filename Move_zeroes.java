/*
  Problem at : https://leetcode.com/problems/move-zeroes/
*/

class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int n = nums.length;
        while(i < n && nums[i] != 0)
            ++i;
        if(i == n)
            return;
        for(int j = i; j < n; ++j){
            int val = nums[j];
            if(val != 0){
                nums[j] = 0;
                nums[i++] = val;
            }
        }
    }
}


