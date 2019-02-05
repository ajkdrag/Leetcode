/*
  Problem at : https://leetcode.com/problems/most-common-word/
*/

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> b = new HashSet<>();
        Map<String, Integer> count = new HashMap<>();
        for(String s : banned)
            b.add(s.toLowerCase());
        
        int max = 0;
        String res = "";
        for(String word : paragraph.split("[\\p{Punct}\\s]+")){
            String curr_w = word.toLowerCase();
            if(!b.contains(curr_w)){
                int curr = 1 + count.getOrDefault(curr_w, 0);
                if(curr > max){
                    max = curr;
                    res = curr_w;
                }
                count.put(curr_w, curr);
            }
        }
        return res;
    }
}


