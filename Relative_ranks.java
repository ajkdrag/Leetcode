/*
  Problem at : https://leetcode.com/problems/relative-ranks/
*/

class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int len = nums.length;
        for(int i = 1;i < len; i++){
            if(nums[i]<min) min = nums[i];
            else if(nums[i]>max) max = nums[i];
        }
        int[] index = new int[max-min+1];
        for(int i = 0; i < len; i++)
            index[nums[i]-min]=i+1;
        String[] result = new String[nums.length];
        int order = 1;
        for(int i = index.length-1; i > -1; i--){
            if(index[i]==0)continue;
            else if(order>3)
                result[index[i]-1] = String.valueOf(order);
            else if(order>2)
                result[index[i]-1] = "Bronze Medal";
            else if(order>1)
                result[index[i]-1] = "Silver Medal";
            else result[index[i]-1] = "Gold Medal"; 
            order++;
        }
        return result;
    }
}


