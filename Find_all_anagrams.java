/*
  Problem at : https://leetcode.com/problems/find-all-anagrams-in-a-string
*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        String hashCode = getHash(p);
        int pLen = p.length();
        int sLen = s.length();
        for(int i = 0; i <= sLen - pLen; ++i){
            if(getHash(s.substring(i,i+pLen)).equals(hashCode))
                res.add(i);
        }
        return res;
    }
    
    String getHash(String s){
        char[] map = new char[26];
        for(char c : s.toCharArray())
            map[c-'a']++;
        return new String(map);
    }
}

// another solution
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] target = new int[128];
        for (char c : p.toCharArray()) target[c]++;
        List<Integer> ans = new ArrayList<>();
        // window [l,r)
        // invariant: the cnt of each char inside the window is no more than the cnt of the corresponding char in target string p
        int l = 0; int r =0 ;
        int[] cnt = new int[128]; // cnt of each char in the window
        int total = 0; // cnt of total chars in the window
        while (r < s.length()) {
            cnt[s.charAt(r)]++; // put char at r into the window
            total++;
            while (cnt[s.charAt(r)] > target[s.charAt(r)]) { // maintain the invariant of the window
                cnt[s.charAt(l++)]--;
                total--;
            }
            // == is satisfied only when each char in the window has exactly the same count as the corresponding char in the target string p
            if (total == p.length()) ans.add(l); 
            
            r++;
        }
        return ans;
    }
}


