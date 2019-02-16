/*
  Problem at : https://leetcode.com/problems/length-of-last-word/
*/

// using trim and split
class Solution {
    public int lengthOfLastWord(String s) {
        return s.trim().length()-s.trim().lastIndexOf(" ")-1;
    }
}

// using only split
class Solution {
    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        if(words.length == 0)
            return 0;
        return words[words.length - 1].length();
    }
}

// without using split or trim
class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int sizeOfLastWord = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ')
                sizeOfLastWord++;
            else if (sizeOfLastWord == 0) 
                continue;
            else 
                break;
        }
        return sizeOfLastWord;
    }
}


