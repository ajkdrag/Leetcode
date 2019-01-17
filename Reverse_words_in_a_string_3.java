/*
  Problem at : https://leetcode.com/problems/reverse-words-in-a-string-iii/
  Solution at : https://leetcode.com/problems/reverse-words-in-a-string-iii/solution/
*/

class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c == ' '){
                res.append(sb.reverse());
                res.append(' ');
                sb.setLength(0);
            }
            else
                sb.append(c);
        }
        res.append(sb.reverse());
        return res.toString();
    }
}


