/*

  Problem at : https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
  Algo : Find the first position of target (using modified Binary search), if it exists, then search the end position of
         target. Note that the search for the end position starts from the first position of the target found, since it's
         futile to start search from index 0. Also, if first position of target is -1, i.e the target doesn't exist in the 
         array, then no need to search the end position.

*/

class Solution {
    static int[] res;
    public int[] searchRange(int[] nums, int target) {
        // initilization
        res = new int[]{-1,-1};
        int len = nums.length;
        // trivial cases
        if(len == 0) return res;
        if(len == 1) return nums[0] == target ? new int[]{0,0} : res;
        // find start position of target
        find_start(nums,0,len-1,target);
        return res;
    }
    
    static void find_start(int[] arr, int start, int end, int target){
        int mid;
        // modified binary search to find the start position
        while(start < end){
            mid = (end + start)>>1; // left bias
            if(arr[mid] < target) start = mid + 1;
            else  end = mid;
        }
        // if we find the target's first position, then only look for it's end position
        if(arr[start] == target){
            res[0] = start;
            // finding the end position making sure to start search from the start position just found
            find_end(arr,start,arr.length-1,target);
        }
    }
    
     static void find_end(int[] arr, int start, int end, int target){
        int mid;
        // modified binary search to find the end position
        while(start < end){
            mid = 1 + (end + start)>>1; // right bias
            if(arr[mid] <= target) start = mid;
            else  end = mid - 1;
        }
        // store the end position in the array
        // note that the end position is the start position itself, if there are no duplicates of the target
        if(arr[start] == target) res[1] = end;
    }
}


