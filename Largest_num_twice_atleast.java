/*
  Problem at : https://leetcode.com/problems/largest-number-at-least-twice-of-others/
*/

// One pass (just find maximum and second maximum)
class Solution {
    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE, index = -1, second = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; --i) {
            int curr = nums[i];
            if (curr > max) {
                second = max;
                max = curr;
                index = i;
            } else if (curr > second)
                second = curr;
        }
        return (second<<1) <= max ? index : -1;
    }
}


