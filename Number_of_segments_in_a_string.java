/*
  Problem at : https://leetcode.com/problems/number-of-segments-in-a-string/
*/

// regex
class Solution {
    public int countSegments(String s) {
        s = "# " + s;
        return -1  + s.split("\\s+").length;
    }
}

// iterative
class Solution {
    public int countSegments(String s) {
        int segmentCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i-1) == ' ') && s.charAt(i) != ' ') {
                segmentCount++;
            }
        }
        return segmentCount;
    }
}


