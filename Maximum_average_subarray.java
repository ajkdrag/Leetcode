/*
  Problem at : https://leetcode.com/problems/maximum-average-subarray-i/
*/

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        int max = 0;
        int i = 0;
        for(; i < k ; ++i)
            max += nums[i];
        int j = 0;
        int curr = max;
        while(i < len){
            curr = curr - nums[j++] + nums[i++];
            max = curr > max ? curr : max;
        }
        return (double)max/k;
    }
}


