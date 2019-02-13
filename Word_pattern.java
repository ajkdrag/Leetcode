/*
  Problem at : https://leetcode.com/problems/word-pattern/
*/

class Solution {
    public boolean wordPattern(String pattern, String str) {
        int len = pattern.length();
        String[] _str = str.split(" ");
        if(len != _str.length)
            return false;
        int[] map1 = new int[128];
        HashMap<String, Integer> map2 = new HashMap<>();
        for(int i = 0; i < len; ++i){
            char c = pattern.charAt(i);
            String s = _str[i];
            if(map1[c] != map2.getOrDefault(s, 0))
                return false;
            map1[c] = i + 1;
            map2.put(s, i + 1);
        }
        return true;
    }
}


