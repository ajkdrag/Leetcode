/*
  Problem at : https://leetcode.com/problems/valid-palindrome/
*/

class Solution {
    public boolean isPalindrome(String s) {
        char[] str = s.trim().toCharArray();
        int i = 0;
        int j = str.length - 1;
        while(i <= j){
            char c1 = Character.toLowerCase(str[i]);
            char c2 = Character.toLowerCase(str[j]);
            if(!Character.isLetter(c1) && !Character.isDigit(c1)){
                ++i;
                continue;
            }
            if(!Character.isLetter(c2) && !Character.isDigit(c2)){
                --j;
                continue;
            }
            
            if(c1 != c2)
                return false;
            ++i;
            --j;
        }
        return true;
    }
}


