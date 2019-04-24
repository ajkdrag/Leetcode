/*
  Problem at : https://leetcode.com/problems/single-number-iii/
*/

public class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = nums[0];
        for(int i = nums.length - 1; i > 0; --i){
            xor ^= nums[i];
        }
        int[] res = new int[2];
        int last_one = xor & (-xor);
        for(int n : nums){
            if((n & last_one) == 0) 
                res[0] ^= n;
            else res[1] ^= n;
        }
        return res;
    }
}


