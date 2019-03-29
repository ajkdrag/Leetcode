/*
  Problem at : https://leetcode.com/problems/k-diff-pairs-in-an-array/
*/

class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0, j = 1; j < nums.length;) {
            if (j <= i || nums[i] + k > nums[j]) {
                j++;
            } else if (i > 0 && nums[i] == nums[i - 1] || nums[i] + k < nums[j]) {
                i++;
            } else {
                ans++;
                i++;
            }
        }
        return ans;
    }
}


