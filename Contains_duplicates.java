/*
  Problem at : https://leetcode.com/problems/contains-duplicate/
*/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums)
            if(set.contains(i))
                return true;
            else
                set.add(i);
        return false;
    }
}


