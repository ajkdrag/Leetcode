/*
  Problem at : https://leetcode.com/problems/groups-of-special-equivalent-strings/
*/

class Solution {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> set= new HashSet<>();
        for (String s : A){
            char[] freq = new char[52];
            int isEven = 0;
            for (char c : s.toCharArray()){
                freq[c-'a' + 26*isEven]++;
                isEven ^= 1;
            }
            set.add(new String(freq));
        }
        return set.size();
    }
}


