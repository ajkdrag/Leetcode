/*
  Problem at : https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
*/

// using built-in stack
class Solution {
    public String removeDuplicates(String S) {
        Stack<Character> st = new Stack<Character>();
        for(char c : S.toCharArray()){
            if(!st.isEmpty() && st.peek() == c)
                st.pop();
            else
                st.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for(char c : st)
            sb.append(c);
        return sb.toString();
    }
}

// using char array (like a stack)
class Solution {
public String removeDuplicates(String S) {
        int i = 0, n = S.length();
        char[] stack = new char[n];
        for (int j = 0; j < n; ++j)
            if (i > 0 && stack[i - 1] == S.charAt(j))
                --i;
            else
                stack[i++] = S.charAt(j);
        return new String(stack, 0, i);
    }
}
  
  
  
