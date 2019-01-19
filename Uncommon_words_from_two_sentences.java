/*
  Problem at : https://leetcode.com/problems/uncommon-words-from-two-sentences/
*/

class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        ArrayList<String> uncommon = new ArrayList<String>();
        HashMap<String, Integer> map = new HashMap<>();
        String temp = A + " " + B + " ";
        StringBuilder sb = new StringBuilder();
        for(char c : temp.toCharArray()){
            if(c == ' '){
                String word = sb.toString();
                map.put(word, 1 + map.getOrDefault(word, 0));
                sb.setLength(0);
            }
            else
                sb.append(c);
        }
        for(String key : map.keySet()){
            if(map.get(key) == 1)
                uncommon.add(key);
        }
        return uncommon.toArray(new String[uncommon.size()]);
    }
}


