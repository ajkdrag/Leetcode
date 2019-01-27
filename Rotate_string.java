/*
  Problem at : https://leetcode.com/problems/rotate-string/
*/

class Solution {
    public boolean rotateString(String A, String B) {
        if(A.length() != B.length())
            return false;
        A = A.concat(A);
        return A.indexOf(B) != -1;
    }
}


