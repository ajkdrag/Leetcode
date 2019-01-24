/*
  Problem at : https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/ 
*/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        for(int i=0; i<len; i++) {
            int m = Math.abs(nums[i]) - 1; // index start from 0
            int x = nums[m];
            nums[m] = x > 0 ? -x : x;
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i<len; i++) {
            if(nums[i] > 0) res.add(i+1);
        }
        return res;
    }
}


