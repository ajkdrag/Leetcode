/*
  Problem at : https://leetcode.com/problems/reverse-string/
*/

class Solution {
    public String reverseString(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] c_arr = s.toCharArray();
        while(i <= j){
           char temp =  c_arr[i];
            c_arr[i++] = c_arr[j];
            c_arr[j--] = temp;
        }
        return String.valueOf(c_arr);
    }
}


