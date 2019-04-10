/*
  Problem at : https://leetcode.com/problems/total-hamming-distance/
*/

class Solution {
    public int totalHammingDistance(int[] nums) {
        int count = 0;
        int len = nums.length;
        for (int i = 0; i < 32; ++i) {
            int k = 0;
            for (int num : nums) {
                k += (num >> i) & 1;
            }
            count += (len - k) * k;
        }      
        return count;
    }
}


