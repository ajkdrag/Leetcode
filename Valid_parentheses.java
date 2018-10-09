/*
  Problem at : https://leetcode.com/problems/valid-parentheses/
  Solution (well explained) at : https://leetcode.com/problems/valid-parentheses/solution/
  Use of HashMap and stack to match the parentheses.
*/

class Solution {
    HashMap<Character, Character> map;
    Stack<Character> stack;
    public boolean isValid(String s) {
        int len = s.length();
        // trivial cases
        if(len == 0) return true;
        if(len == 1) return false;
        map = new HashMap<>();
        map.put(']','[');
        map.put('}','{');
        map.put(')','(');
        
        stack = new Stack<Character>();
        for(int i = 0; i < len; ++i){
            char token = s.charAt(i);
            if(map.containsKey(token)){
                // if the closing bracket is matched with its corresponding opening bracket, we pop from the stack eg: "()"
                if(!stack.isEmpty() && stack.peek() == map.get(token)) stack.pop()
                // otherwise we return false eg: "{)"
                else return false;
            }
            // if opening bracket, then push into the stack
            else stack.push(token);
        }
        // if stack is not empty, return false
        return stack.isEmpty();
    }
}

