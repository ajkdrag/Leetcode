/*
  Problem at : https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
*/

// Solution (using stacks)
// link : https://leetcode.com/problems/shortest-unsorted-continuous-subarray/solution/
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        Stack < Integer > stack = new Stack < Integer > ();
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i])
                l = Math.min(l, stack.pop());
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
                r = Math.max(r, stack.pop());
            stack.push(i);
        }
        return r - l > 0 ? r - l + 1 : 0;
    }
}

// Solution (without stacks, find the valley and peak)
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int r = -1;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= max) {
                max = nums[i];
            } else {
                r = i;
            }
        }
        if (r == -1) {
            return 0;
        }
        int l = r - 1;
        int min = nums[r];
        for (int i = r - 1; i >= 0; i--) {
            if (nums[i] <= min) {
                min = nums[i];
            } else {
                l = i;
            }
        }
        return r - l + 1;
    }
}

