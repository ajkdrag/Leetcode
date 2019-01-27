/*
  Problem at : 
*/

// Using a HashSet with two passes is the obvious solution. Here is a little different one
class Solution {
    public int firstUniqChar(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        for(int i = 0; i < n; ++i) {
            char c = arr[i];
            int temp = s.indexOf(c);
            if(temp == s.lastIndexOf(c)){
                return temp;
            }
        }
        return -1;
    }
}

// This one is faster because there is no array indexing inside the loop
class Solution {
    public int firstUniqChar(String s) {
        int pos = Integer.MAX_VALUE;
        for(char i='a';i<='z';i++) {
            int temp = s.indexOf(i);
            if(temp!=-1 && temp == s.lastIndexOf(i))
                pos = pos < temp ? pos : temp;
        }
        return (pos == Integer.MAX_VALUE) ? -1 : pos;
    }
}


