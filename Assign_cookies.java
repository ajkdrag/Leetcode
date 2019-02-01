/*
  Problem at : https://leetcode.com/problems/assign-cookies/
*/

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int count = 0;
        int j = g.length - 1;
        Arrays.sort(g);
        Arrays.sort(s);
        
        for(int i = s.length - 1; i >= 0 && j >= 0; --i){
            while(j >= 0 && g[j] > s[i])
                --j;
            if(j-- >= 0)
                ++count;
            
        }
        return count;
    }
}


