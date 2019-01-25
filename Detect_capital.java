/*
  Problem at : https://leetcode.com/problems/detect-capital/ 
*/

class Solution {
    public boolean detectCapitalUse(String word) {
        int len = word.length();
        char[] arr = word.toCharArray();
        if(len == 1)
            return true;
        int numCapitals = 0;
        for(int i = len - 1; i >= 1; --i){
            char c = arr[i];
            if(c <= 'Z')
                ++numCapitals;
            if(numCapitals > 0 && numCapitals < (len - i))
                return false;
        }
        if(numCapitals > 0 && !(arr[0] <= 'Z'))
            return false;
        return true;
    }
}


