/*
  Problem at : https://leetcode.com/problems/verifying-an-alien-dictionary/
*/

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] chars = new int[26];
        for(int i = 0;i<26;i++){
            chars[order.charAt(i)-'a'] = i;
        }
        for(int i = 0;i<words.length-1;i++){
            if(!helper(words[i],words[i+1],chars)) return false;
        }
        return true;
    }
    
    public boolean helper(String a, String b, int[] order){
        for(int i = 0;i<a.length()&&i<b.length();i++){
            int compare = order[a.charAt(i)-'a']-order[b.charAt(i)-'a'];
            if(compare<0) return true;
            else if(compare>0) return false;
        }
        if(a.length()>b.length()) return false;
        return true;
    }
}


