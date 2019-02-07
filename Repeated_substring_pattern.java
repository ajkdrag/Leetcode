/*
  Problem at : https://leetcode.com/problems/repeated-substring-pattern/
*/

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int l = s.length();
        int div = 1;
        int size = l/div;
        while(++div <= l){
            size = l/div;
            boolean found = true;
            if(size*div == l){
                for(int j = s.length() - 1, end = j - size; j > end; --j){
                    for(int i = j; i >= size; i -= size){
                        if(s.charAt(i) != s.charAt(i - size)){
                            found = false;
                            break;
                        }
                    }
                    if(!found)
                        break;
                }
                if(found)
                    return found;
            }
        }
        return false;
    }
}


