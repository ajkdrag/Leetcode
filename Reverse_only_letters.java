/*
  Problem at : https://leetcode.com/problems/reverse-only-letters/
*/

class Solution {
    public String reverseOnlyLetters(String S) {
        char[] arr = S.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        while(i < j){
            char c1 = arr[i];
            char c2 = arr[j];
            while(!Character.isLetter(c1)){
                ++i;
                if(i >= j)
                    break;
                c1 = arr[i];
            }
                
            while(!Character.isLetter(c2)){
                --j;
                if(i >= j)
                    break;
                c2 = arr[j];
            }
            if(i < j){
                arr[j--] = c1;
                arr[i++] = c2;
            }
        }
        return String.valueOf(arr);
    }
}


