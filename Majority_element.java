/*
  Problem at : https://leetcode.com/problems/majority-element/
*/

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n>>1];
    }
}


