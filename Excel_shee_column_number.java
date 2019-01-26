/*
  Problem at : https://leetcode.com/problems/excel-sheet-column-number/
*/

class Solution {
    public int titleToNumber(String s) {
        int res = 0;
        for(char c : s.toCharArray()){
            res = res*26 + (c-'A'+1);
        }
        return res;
    }
}


