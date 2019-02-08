/*
  Problem at : https://leetcode.com/problems/contains-duplicate-ii/
*/

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int num = 0;
        int prev = 0;
        int len = nums.length;
        for(int i = 0; i < len; ++i){
            num = nums[i];
            prev = map.getOrDefault(num, -k - 1);
            if(i - prev <= k)
                return true;
            map.put(num, i);
        }
        return false;
    }
}


