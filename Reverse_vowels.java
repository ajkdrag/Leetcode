/*
  Problem at : https://leetcode.com/problems/reverse-vowels-of-a-string/
*/

class Solution {
    public String reverseVowels(String str) {
        char[] arr = str.toCharArray();
        HashSet<Character> vowels = new HashSet(){{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
            add('A');
            add('E');
            add('I');
            add('O');
            add('U');
        }};
        int start = 0;
        int end = arr.length - 1;
        while(start < end){
            char s = arr[start];
            char e = arr[end];
            if(!vowels.contains(s)){
                ++start;
                continue;
            }
            if(!vowels.contains(e)){
                --end;
                continue;
            }
            else{
                arr[start++] = e;
                arr[end--] = s;
            }
        }
        return String.valueOf(arr);
    }
}


