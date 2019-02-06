/*
  Problem at : https://leetcode.com/problems/longest-harmonious-subsequence/
  Solution at : https://leetcode.com/problems/longest-harmonious-subsequence/solution/
*/

// sort based solution
class Solution {
    public int findLHS(int[] nums) {
        int result = 0;   
        Arrays.sort(nums);
        int left = 0 , right = 1;
        while(right<nums.length){
            while(nums[right]-nums[left]>1) ++left;  
            if(right-left+1 > result && nums[right] - nums[left] == 1) 
                result = right-left+1;
            ++right;
        }
        return result;
    }
}


