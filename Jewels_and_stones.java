/*
  Problem at : https://leetcode.com/problems/jewels-and-stones/
*/

class Solution {
    public static int numJewelsInStones(String J, String S) {
        int count = 0;
        int[] table = new int[128];
        for(int i = S.length() - 1; i >= 0; --i){
            char c = S.charAt(i);
            table[c]++;
        }
        
        for(int j = J.length() - 1; j >= 0; --j){
            count += table[J.charAt(j)];
        }
        
        return count;
    }
}

// alternate solution 
public static int numJewelsInStones(String J, String S) {
       int res=0;
       for(char c : S.toCharArray()){
           if(J.indexOf(c) != -1){
               res++;
           }
       }
       return res;
    }
    
    
