/*
  Problem : https://leetcode.com/problems/implement-strstr/
  Algo : Basic implementation of .indexOf() , by use of .equals method of the String class.
*/

class Solution {
    public int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        if(len2 == 0) return 0;
        if(needle.equals(haystack)) return 0;
        int i = -1;
        while(++i <= len1-len2){
            if(needle.equals(haystack.substring(i,i+len2))) return i;
        }
        return -1;
    }
}


