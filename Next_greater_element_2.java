/*
  Problem at : https://leetcode.com/problems/next-greater-element-ii/
*/

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        if(len == 0)
            return res;
        int first = -1;
        for(int i = 0; i < len - 1; ++i){
            if(nums[i] > nums[len - 1]){
                first = i;
                break;
            }
        }
        
        for(int i = first; i >= 0 && i < len - 1; ++i){
            res[i] = i + 1;
        }
        
        res[len-1] = first;

        for(int i = len - 2; i >= 0; --i){
            if(nums[i] < nums[i+1]){
                res[i] = i+1;
            }
            else {
                int j = i + 1;
                while(j < len && res[j] == -1)
                    ++j;
                if(j >= len){
                    res[i] = -1;
                    continue;
                }
                int curr = nums[res[j]];
                while(nums[i] >= curr){
                    if(i == res[j]){
                        j = len;
                        break;
                    }
                    j = res[j];
                    if(res[j] == -1){
                        j = len;
                        break;
                    }
                    curr = nums[res[j]];
                }
                if(j >= len){
                    res[i] = -1;
                    continue;
                }
                
                res[i] = res[j];
            }
        }
        for(int i = 0; i < len; ++i){
            if(res[i] == -1)
                continue;
            res[i] = nums[res[i]];
        }
        return res;
    }
}


