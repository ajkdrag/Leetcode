/*
  Problem at : https://leetcode.com/problems/string-compression/
*/

// 2 pointer solution
class Solution {
    public int compress(char[] str) {
        int len = 0;
        for(int i=0, j=0; i < str.length; i=j)
        {
            while(j < str.length && str[i]==str[j]) j++;
            str[len++] = str[i];
            if((j-i)<=1) continue;
            for(char c : Integer.toString(j - i).toCharArray()) str[len++] = c;
        }
        return len;
    }
}


