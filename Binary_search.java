/*
  Problem at : https://leetcode.com/problems/binary-search/
*/

class Solution {
    int[] nums;
    int target;
    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        if(target > nums[nums.length - 1])
            return -1;
        if(target < nums[0])
            return -1;
        return BS(0, nums.length - 1);
    }
    
    public int BS(int s, int e){
        while(s <= e){
            int mid = (s + e)>>1;
            int curr= nums[mid];
            if(curr == target){
                return mid;
            }
            else if(curr < target){
                s = mid + 1;
            }
            else
                e = mid - 1;
        }
        return -1;
    }
}


