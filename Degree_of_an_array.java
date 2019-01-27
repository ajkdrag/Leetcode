/*
  Problem at : https://leetcode.com/problems/degree-of-an-array/
*/

class Solution {
    public int findShortestSubArray(int[] nums) {
      Map<Integer, Integer> counter = new HashMap<>(), last = new HashMap<>();
        int res = 0, degree = 0;
        for (int i = nums.length - 1; i >= 0; --i) {
            int curr = nums[i];
            last.putIfAbsent(curr, i);
            int val = counter.getOrDefault(curr, 0) + 1;
            counter.put(nums[i], val);
            int len = last.get(curr) - i + 1;
            if (val > degree) {
                degree = val;
                res = len;
            } else if (val == degree)
                res = len < res ? len : res;
        }
        return res;  
    }
}


