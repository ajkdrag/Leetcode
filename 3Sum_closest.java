/*
  Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. 
  Return the sum of the three integers.
  You may assume that each input would have exactly one solution.
  
  Similar to the usual 3Sum problem, we use the 2 pointer approach, but since we are looking for the closest result.
  Everytime we compute a sum, we compare how close it is to the target and update accordingly.
*/

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // sort the array
        Arrays.sort(nums);
        int n = nums.length; 
        // res holds the closest result (can be initialized to anything, since it will be updated anyway)
        int res = Integer.MAX_VALUE;  
        // trivial case when n <= 3, return the sum of the all the values
        if (n <= 3) {
            for (int num:nums) 
                res += num; 
            return res; 
        }
        
        // diff stores the diff between our current closest result and the target
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i <= n - 3; i++) {
            // j and k are our two pointers
            int j = i + 1; 
            int k = n - 1; 
            while (j < k) {
                // sum = our current sum which will be checked against the target
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > target){
                    k--;
                    // if the current sum is closer than our current closest difference, we update
                    if(diff > (sum - target)){
                        diff = sum - target;
                        res = sum;
                    }
                }
                // similar as above
                else if(sum < target){
                    j++;
                    if(diff > (target - sum)){
                        diff = target - sum;
                        res = sum;
                    }
                }
                // else our sum equals the target, i.e we can't get any closer, hence return it.
                else return sum;
            }
        }
        return res; 
    }
}

