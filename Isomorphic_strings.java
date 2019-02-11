/*
  Problem at : https://leetcode.com/problems/isomorphic-strings/
*/

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] m1 = new int[256], m2 = new int[256]; 
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (m1[c1] != m2[c2]) return false;
            m1[c1] = i + 1;
            m2[c2] = i + 1;
        }
        return true;
    }
}


