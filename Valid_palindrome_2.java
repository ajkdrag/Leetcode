/*
  Problem at : https://leetcode.com/problems/valid-palindrome-ii/
*/

class Solution {
    public boolean validPalindrome(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        return helper(arr, i , j, false);
    }
    
    boolean helper(char[] arr, int i , int j , boolean operated){
        while(i < j){
            if(arr[i] != arr[j]){
                if(!operated){
                    return helper(arr, i + 1, j, true) ||
                        helper(arr, i, j - 1, true);
                }
                else
                    return false;
            }
            else{
                ++i;
                --j;
            }
        }
        return true;
    }
}


