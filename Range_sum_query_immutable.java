/*
  Problem at : https://leetcode.com/problems/range-sum-query-immutable/
*/

class NumArray {
    int[] cumsum;
    public NumArray(int[] nums) {
        int len = nums.length;
        cumsum = new int[len + 1];
        cumsum[0] = 0;
        for(int i = 1; i <= len; ++i)
            cumsum[i] = cumsum[i - 1] + nums[i-1]; 
    }
    
    public int sumRange(int i, int j) {
        return cumsum[j+1] - cumsum[i];
    }
}


