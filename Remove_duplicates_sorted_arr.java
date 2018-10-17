/*
  Problem at : https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
  Algo : Use of 2 pointers i, j where elements to the left of 'i' are distinct and 'j' points to elements yet to be checked.
         The array slot to which 'i' points is the slot where a distinct element will go to, and then 'i' will be incremented by 1.
         When you encounter an element (by nums[j]) you first check if it's distinct or not (by nums[j] != nums[i-1]). Since
         i - 1 points to the most recent distinct element and also since the array is sorted, we only need to compare nums[j] with
         nums[i - 1]. Once we find out that the element is distinct, we 'put' it in the slot pointed by 'i' (by nums[i] = nums[j]).
         Once we are done with that, we can increment 'i' to accomodate further distinct elements.
         
  eg :  {0, 0, 1, 1, 1, 2}  i = 1 since first element is already a distinct one, j = 0
  
        ++j (j = 1 now) < len ? YES, so we proceed : (i = 1, j = 1)
        nums[j] == nums[i-1] ? TRUE, so we skip this element
        {0, 0, 1, 1, 1, 2}
        
        ++j (j = 2 now) < len ? YES, so we proceed : (i = 1, j = 2)
        nums[j] == nums[i-1] ? FALSE, so 'put' nums[j] in 'i'th slot and increment 'i' (i = 2 now)
        {0, 1, 1, 1, 1, 2}
        
        ++j (j = 3 now) < len ? YES, so we proceed : (i = 2, j = 3)
        nums[j] == nums[i-1] ? TRUE, so we skip this element
        {0, 1, 1, 1, 1, 2}
        
        ++j (j = 4 now) < len ? YES, so we proceed : (i = 2, j = 4)
        nums[j] == nums[i-1] ? TRUE, so we skip this element
        {0, 1, 1, 1, 1, 2}
        
        ++j (j = 5 now) < len ? YES, so we proceed : (i = 2, j = 5)
        nums[j] == nums[i-1] ? FALSE, so 'put' nums[j] in 'i'th slot and increment 'i' (i = 3 now)
        {0, 1, 2, 1, 1, 2}
        
        ++j (j = 6 now) < len ? NO, so FINISH
        
        return i ('i' also indicates the number of distinct elements to it's left in any iteration)
*/


class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 1;
        int j = 0;
        int len = nums.length;
        if(len <= 1) return len;
        while(++j < len){
            if(nums[j] != nums[i-1]) nums[i++] = nums[j];
        }
        return i;
    }
}


