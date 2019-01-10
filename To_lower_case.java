/*
  Problem at : https://leetcode.com/problems/to-lower-case/
*/

class Solution {
    StringBuilder sb = new StringBuilder();
    public String toLowerCase(String str) {
        for(char c : str.toCharArray()){
            if(c >= 97 && c <= 122)
                sb.append(c);
            else if(c >= 65 && c <= 90)
                sb.append((char)(c + 32));
            else 
                sb.append(c);
        }
        return sb.toString();
    }
}


