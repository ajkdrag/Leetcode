/*
  Problem at : https://leetcode.com/problems/goat-latin/
*/

class Solution {
    public static final Character[] vowelsList = new Character[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
    public static final HashSet<Character> vowels = new HashSet<Character>(Arrays.asList(vowelsList));
    
    public String toGoatLatin(String S) {
        if(S == null || S.length() == 0) {
            return "";
        }
        StringBuilder answer = new StringBuilder();
        StringBuilder word = new StringBuilder();
        int wordIndex = 1;
        
        S = S + " ";
        
        for(char c : S.toCharArray()){
            if(c == ' '){
                char firstCharacter = word.charAt(0);
                if (vowels.contains(firstCharacter)) {
                answer.append(word);
                } else {
                    answer.append(word.substring(1));
                    answer.append(firstCharacter);
                }
                answer.append("ma"); 
                for (int i = 0; i < wordIndex; i++) {
                    answer.append("a");
                }
                answer.append(c);
                ++wordIndex;
                word.setLength(0);
            }
            else {
                word.append(c);
            }
        }
        
        return answer.substring(0, answer.length() - 1);
    }
}


