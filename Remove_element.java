/*
  Problem at : https://leetcode.com/problems/remove-element/description/
  Algo : Use of 2 pointers --> 'i' and 'j'
         Elements to the left of 'i' are not equal to the target val while 'j' points to unchecked elements.
         Whenever we encounter a value that's equal to the target val, we do nothing. When we encounter a 
         value that's not equal to target val, we 'put'/accomodate it inside 'i' (by nums[i++] = value)
         The increment makes sure that everything to the left of 'i' is different from target val and so on.
*/

class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = -1;
        int len = nums.length;
        int t = 0;
        while(++j < len){
            t = nums[j];
            if(t != val) nums[i++] = t;
        }
        return i;
    }
}


