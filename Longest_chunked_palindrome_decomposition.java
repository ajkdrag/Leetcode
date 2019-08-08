/*
Problem at : https://leetcode.com/problems/longest-chunked-palindrome-decomposition/
*/

// iterative
class Solution {
    public int longestDecomposition(String S) {
        int res = 0, n = S.length();
        String l = "", r = "";
        for (int i = 0; i < n; ++i) {
            l = l + S.charAt(i);
            r = S.charAt(n - i - 1) + r;
            if (l.equals(r)) {
                ++res;
                l = "";
                r = "";
            }
        }
        return res;
    }
}


// recursive
class Solution {
   public int longestDecomposition(String text) {
        int n = text.length();   
        for (int i = 0; i < n/2; i++) 
            if (text.substring(0, i + 1).equals(text.substring(n-1-i, n))) 
                return 2+longestDecomposition(text.substring(i+1, n-1-i));
        return (n==0)?0:1;
    }
}


