/*
  Problem at : https://leetcode.com/problems/search-insert-position/description/
  Algo : Use of modified binary search to find the index of the largest element <= target i.e floor value index
         Check if the element in the index is target itself, in which case, return that index, else
         return that index + 1, indicating that the target needs to be inserted at the next index, to preserve the order.
*/

class Solution {
    public int searchInsert(int[] nums, int target) {
        // trivial cases
        int len = nums.length;
        if(len == 0 || target < nums[0] ) return 0;
        int start = 0;
        int end = nums.length - 1;
        // modified binary search to find index of 'floor'
        while(start < end){
            int mid = 1 + (start + end)>>1;
            if(nums[mid] > target) end = mid - 1;
            else start = mid;
        }
        // check if target exists, in which case, return the floor index
        if(nums[start] == target) return start;
        // else return floor index + 1
        return start + 1;
    }
}


