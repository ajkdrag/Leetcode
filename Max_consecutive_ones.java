/*
  Problem at : https://leetcode.com/problems/max-consecutive-ones/
*/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int soFar = 0, max = 0;
        for (int n : nums){
            soFar = (soFar + 1)*n;
            if(soFar > max)
                max = soFar;
        }
        return max; 
    } 
}


