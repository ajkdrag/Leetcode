/*
  Problem at : https://leetcode.com/problems/count-and-say/description/
*/

class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        if(n == 2) return "11";
        StringBuilder sb = new StringBuilder("11");
        char[] chars;
        for(int j = 3; j <= n; ++j){
            int count = 1;
            int i = 1;
            int len = sb.length();
            chars = new char[len];
            sb.getChars(0,len,chars,0);
            sb.setLength(0);
            for( ; i < len; ++i){
                if(chars[i]!=chars[i-1]){
                    sb.append(count);
                    sb.append(chars[i-1]);
                    count = 1;
                }   
                else count++;
            }
            sb.append(count);
            sb.append(chars[i-1]);
        }
        return sb.toString();
    }
}


