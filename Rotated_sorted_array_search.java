/*
  Problem at : https://leetcode.com/problems/search-in-rotated-sorted-array/
  Algo : Since the array is rotated, leftmost value is > rightmost value (only exception is when array is same after rotation)
         When we find the middle index, arr[mid] can lie on the increasing sequence of "1st half" or the "2nd half"; hence we
         have two cases : eg : arr = {1,2,3,4,5,6,7}, after rotation --> arr = {5,6,7,1,2,3,4}
         Rotation gave us "two increasing sequences" i) {5,6,7} ii) {1,2,3,4} Middle element in this case lies in the 2nd seq.
         a) If mid is in the 1st sequence and arr[left] <= target <= arr[mid], then we search in the space left of 'mid';
         otherwise search right.
         b) If mid is in the 2nd sequence and arr[mid] <= target <= arr[right], then we search in the space right of 'mid';
         otherwise search left, and so on...
*/

class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        // trivial cases
        if(len == 0) return -1;
        if(len == 1) return target == nums[0] ? 0 : -1;
        
        int l = 0; 
        int r = len - 1;
        
        while(l <= r){
            int mid = l + ((r - l)>>1);
            int mid_val = nums[mid];
            // case when we found the target
            if(mid_val == target) return mid;
            // if mid_val > nums[right] ==> case_1, otherwise case_2 {case_1 is mid lying in 1st increasing subseq. and vice versa}
            else if(mid_val > nums[r]){
                // condition to search in space left of mid   --> (a)
                if(target <= mid_val && target >= nums[l]) r = mid - 1;
                else l = mid + 1;
            }
            else {
                // condition to search in space right of mid  --> (b)
                if(target >= mid_val && target <= nums[r]) l = mid + 1;
                else r = mid - 1;
            }
        }
        // target not found
        return -1;
    }
}


