/*
  Problem at : https://leetcode.com/problems/minimum-window-substring/
*/

class Solution {
    public String minWindow(String s, String t) {
        int[] charCnt = new int[256];
        int ct = 0;
        for(char c : t.toCharArray()){
            charCnt[c]++;
            ++ct;
        }
        int bestSt = -1;
        int bestEd = -1;
        int best = Integer.MAX_VALUE;
        int winStrt = 0;
        char[] sarr = s.toCharArray();
        for(int i = 0, j = s.length(); i < j; ++i){
            if(i-winStrt+1 > best){
                char toRmv = sarr[winStrt];
                if(charCnt[toRmv] >= 0)
                    ++ct;
                charCnt[toRmv]++;
                ++winStrt;
            }
            char curr = sarr[i];
            if(charCnt[curr] > 0)
                --ct;
            charCnt[curr]--;
            if(ct == 0){
                while(charCnt[sarr[winStrt]] < 0){
                    charCnt[sarr[winStrt]]++;
                    ++winStrt;
                }
                if(i-winStrt+1 < best){
                    best = i-winStrt+1;
                    bestSt = winStrt;
                    bestEd = i;
                }
            }
        }
        if(best==Integer.MAX_VALUE)
            return "";
        return s.substring(bestSt, bestEd+1);
    }
}

