/*
  Problem at : https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
*/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int low = 1;
        int high = numbers.length;
        while(low < high){
            int sum = numbers[low - 1] + numbers[high - 1];
            if(sum < target)
                ++low;
            else if(sum > target)
                --high;
            else
                return new int[]{low, high};
        }
        return new int[]{-1, -1};
    }
}


