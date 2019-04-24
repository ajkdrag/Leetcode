/*
  Problem at : https://leetcode.com/problems/single-element-in-a-sorted-array/ 
*/

Using xor O(n)
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int res = nums[0];
        for(int i = nums.length - 1; i > 0; --i)
            res ^= nums[i];
        return res;
    }
}

Using binary search O(logn)
public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length, lo=0, hi=n>>1;
        while (lo < hi) {
            int m = (lo + hi)>>1;
            if (nums[m<<1]!=nums[(m<<1)+1]) hi = m;
            else lo = m+1;
        }
        return nums[lo<<1];
    }
}


