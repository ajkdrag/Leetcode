/*
  Problem at : https://leetcode.com/problems/score-of-parentheses/
*/

class Solution {
    public int scoreOfParentheses(String S) {
        int sum = 0;
        int multiplier = 0;
        int len = S.length();
        for(int i = 0; i < len; ++i){
            char c = S.charAt(i);
            if(c == '('){
                if(multiplier == 0)
                    multiplier = 1;
                else 
                    multiplier <<= 1;
            }
            else if(c == ')'){
                if(S.charAt(i - 1) == '(')
                    sum += multiplier;
                multiplier >>= 1;
            }
        }
        return sum;
    }
}

// concise version (from solution)
class Solution {
    public int scoreOfParentheses(String S) {
        int ans = 0, bal = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') {
                bal++;
            } else {
                bal--;
                if (S.charAt(i-1) == '(')
                    ans += 1 << bal;
            }
        }
        return ans;
    }
}


