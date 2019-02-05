/*
  Problem at : https://leetcode.com/problems/set-mismatch/
*/

// counter solution
class Solution {
    public int[] findErrorNums(int[] nums) {
        int len = nums.length;
        int[] count = new int[len + 1];
        int total = (len*(len + 1))>>1;
        int dup = 0;
        for(int i = len - 1; i >= 0; --i){
            int curr = nums[i];
            if(count[curr] == 1){
                dup = curr;
            }
            else{
                total -= curr;
                count[curr]++;
            }
        }
        return new int[]{dup, total};
    }
}


