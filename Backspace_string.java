/*
  Problem at : https://leetcode.com/problems/backspace-string-compare/
  Solution at : https://leetcode.com/problems/backspace-string-compare/solution/
*/

// Two stack solution 
class Solution {
    static boolean backspaceCompare(String S, String T) {
        Stack<Character> st = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        for(char c : S.toCharArray()){
            if(c == '#'){
                if(!st.isEmpty())
                    st.pop();
            }
            else
                st.push(c);
        }
        for(char c : T.toCharArray()){
            if(c == '#'){
                if(!st2.isEmpty())
                    st2.pop();
            }
            else
                st2.push(c);
        }
        return st.toString().equals(st2.toString());
    }
}

// Single stack solution 
class Solution {
    static boolean backspaceCompare(String S, String T) {
        Stack<Character> st = new Stack<>();
        for(char c : S.toCharArray()){
            if(c == '#'){
                if(!st.isEmpty())
                    st.pop();
            }
            else
                st.push(c);
        }
        char[] arr = T.toCharArray();
        int skip_counter = 0;
        for(int i = arr.length - 1; i >= 0; --i){
            char c = arr[i];
            if(c == '#')
                ++skip_counter;
            else if(skip_counter > 0){
                --skip_counter;
            }
            else {
                if(!st.isEmpty() && st.peek() == c)
                    st.pop();
                else
                    return false;
            }
        }
        return st.isEmpty();
    }
}

// Two pointer solution 
class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        for (i = findValid(S, i), j = findValid(T, j); i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j);) {
            i = findValid(S, i - 1);
            j = findValid(T, j - 1);
        }
        if (i < 0 && j < 0) {
            return true;
        }
        else {
            return false;
        }
    }
    
    int findValid(String s, int start) {
        boolean sharp = true;
        int len = 0;
        int i = start;
        for (; i >= 0; --i) {
            if (s.charAt(i) == '#') {
                ++len;
            }
            else {
                if (len == 0) return i;
                else --len;
            }
        }
        return i;
    }
}


