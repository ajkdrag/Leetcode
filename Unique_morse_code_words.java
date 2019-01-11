/*
  Problem at : https://leetcode.com/problems/unique-morse-code-words/
*/

class Solution {
    HashSet<String> codes;
    StringBuilder sb;
    public int uniqueMorseRepresentations(String[] words) {
        codes = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        String[] map = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.",
                            "---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        for(String word : words){
            for(char c : word.toCharArray()){
                sb.append(map[c-'a']);
            }
            codes.add(sb.toString());
            sb.setLength(0);
        }  
        return codes.size();
    }
}


