/*
  Problem at : https://leetcode.com/problems/non-decreasing-array/
  Solution at : https://leetcode.com/problems/non-decreasing-array/solution/
*/

class Solution {
    public boolean checkPossibility(int[] nums) {
        int idToReplace = -1;
        int i = 0; 
        int j = nums.length;
        for(; i < j - 1; ++i){
            if(nums[i] > nums[i + 1]){
                if(idToReplace != -1)
                   return false;
               idToReplace = i;
            }
        }
        if(idToReplace == -1 || idToReplace == 0 || idToReplace == j - 2 ||
          nums[idToReplace - 1] <= nums[idToReplace + 1] || nums[idToReplace] <= nums[idToReplace + 2])
            return true;
        return false;
    }
}


