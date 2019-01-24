/*
  Problem at : https://leetcode.com/problems/find-the-difference/
*/

class Solution {
    public char findTheDifference(String s, String t) {
        return (char)(getVal(s)^getVal(t));
    }
    
    int getVal(String s){
        int x = 0;
        for(char c : s.toCharArray())
            x ^= c;
        return x;
    }
}


