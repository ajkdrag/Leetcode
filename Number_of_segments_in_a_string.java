/*
  Problem at : https://leetcode.com/problems/number-of-segments-in-a-string/
*/

class Solution {
    public int countSegments(String s) {
        s = "# " + s;
        return -1  + s.split("\\s+").length;
    }
}


