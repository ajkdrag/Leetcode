/*
  Problem at : https://leetcode.com/problems/count-binary-substrings/ 
*/

class Solution {
    public int countBinarySubstrings(String s) {
        s = "#" + s;
        char[] arr = s.toCharArray();
        int i = 1;
        int prev = 1;
        int curr = 0;
        int res = 0;
        while(i < arr.length){
            if(arr[i] != arr[i-1]){
                prev = curr;
                curr = 1;
            }
            else
                ++curr;
            if(prev >= curr){
                res++;
            }
            ++i;
        }
        return res;
    }
}


