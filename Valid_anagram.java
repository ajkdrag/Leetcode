/*
  Problem at : https://leetcode.com/problems/valid-anagram/
*/

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] map = new int[26];
        if(s.length() != t.length())
            return false;
        for(char c : s.toCharArray())
            map[c-'a']++;
        for(char c : t.toCharArray()){
            int index = c - 'a';
            if(map[index] <= 0)
                return false;
            map[index]--;
        }
        return true;
    }
}


