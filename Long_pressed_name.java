/*
  Problem at : https://leetcode.com/problems/long-pressed-name/
*/

class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int len1 = name.length();
        int len2 = typed.length();
        if(len2 < len1 || name.charAt(0) != typed.charAt(0))
            return false;
        int start1 = 0;
        int start2 = 0;
        while(start1 < len1 && start2 < len2){
            if(name.charAt(start1) == typed.charAt(start2)){
                ++start1;
                ++start2;
            }
            else if(typed.charAt(start2) == typed.charAt(start2 - 1))
                ++start2;
            else
                return false;
        }
        if(start1 < len1)
            return false;
        return true;
    }
}


