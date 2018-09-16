/*

  Given a string and a pattern, we need to implement regular expression matching with support for '.' and '*'.
  '.' matches any single character, whereas '*' matches 0 or more of the preceding element.
  eg :  S = "aab"
        P = "c*a*b"
        Output: true
        
  We will use Dynamic Programming approach to solve this problem.
  First assume that the strings and patterns have a token '#' prefixed to them.
  i.e S = "#aab"
      P = "#c*a*b"
  
  For trivial case, we have the case where pattern starts with '*' which is absurd, so return False.
  Now we create our 2D matrix/DP the rows represent the letters of the pattern and columns represent letters of the string
  intialized with all entries as False.
  
                  # | a | a | b |
                # F | F | F | F |
                c F | F | F | F |
                * F | F | F | F |
                a F | F | F | F |
                * F | F | F | F |
                b F | F | F | F |
                
  For the 1st row, we can be sure that all entries will remain False, except for dp[#][#] because empty pattern matches empty string
  
                  # | a | a | b |
                # T | F | F | F |
               -------------------
                c F | F | F | F |
                * F | F | F | F |
                a F | F | F | F |
                * F | F | F | F |
                b F | F | F | F |
                
  Moreover, when we look at the entries of the 1st column, it implies that we have an empty string. Now an empty string can only
  be matched if the pattern is like : _*_*_* ... or _**** ...

  eg : a* matches with empty string, and so will a**, .*, a***... , a*b* , but ab* won't match, neither will ab***, a*b*c ...
  Thus whenever the pattern ends in a symbol that's not a '*', it will remain False, but if the pattern ends in a '*', it will only
  be matched with empty string, if there was a match till the preceding symbol or there was a match by considering 0 occurences
  of the preceding element.
  
  i.e : if string is empty and symbol is '*' --> dp[i][j] = dp[i-1][j] || dp[i-2][j] Thus, we have : 
               
                  # | a | a | b |
                # T | F | F | F |
               -------------------
                c F | F | F | F |
                * T | F | F | F |
                a F | F | F | F |
                * T | F | F | F |
                b F | F | F | F |
  
  If the symbol and the character from the string aren't the same, then it's not a match
  If they are the same then we need to check that excluding them, was there a match or not.
  
  i.e if symbol and character matched --> dp[i][j] = dp[i-1][j-1]
  
  But if the symbol is '*' we need to check the preceding element as well. If the preceding symbol is same as the current character
  or the preceding symbol was a '.', then match will occur if there was a match so far before we hit the current character.
  
  i.e : if symbol is '*' and pattern[i-1] == string[j] or pattern[i-1] = '.' --> dp[i][j] = dp[i][j-1]
  
  Also, there will be a match if there was a match without including this '*' (implying 1 occurence of preceding symbol)
  or there was a match before the preceding symbol (implying 0 occurence of the preceding symbol)
  
  i.e --> dp[i][j] = dp[i][j] || dp[i-1][j] || dp[i-2][j]
  
                  # | a | a | b |
                # T | F | F | F |
                c F | F | F | F |
               -------------------
                * T | F | F | F |
                a F | F | F | F |
                * T | F | F | F |
                b F | F | F | F |
                
                
                  # | a | a | b |
                # T | F | F | F |
                c F | F | F | F |
                * T | F | F | F |
               -------------------
                a F | F | F | F |
                * T | F | F | F |
                b F | F | F | F |
                
                
                  # | a | a | b |
                # T | F | F | F |
                c F | F | F | F |
                * T | F | F | F |
                a F | T | F | F |
               -------------------
                * T | F | F | F |
                b F | F | F | F |
                
                
                  # | a | a | b |
                # T | F | F | F |
                c F | F | F | F |
                * T | F | F | F |
                a F | F | F | F |
                * T | T | T | F |
               -------------------
                b F | F | F | F |
                
                
                  # | a | a | b |
                # T | F | F | F |
                c F | F | F | F |
                * T | F | F | F |
                a F | F | F | F |
                * T | T | T | F |
                b F | F | F | T |
               
               
  Thus, we have our matrix filled and the last cell gives the final output whether the pattern matched the string or not.
  The implementation uses the same algo as described above, but without the '#' token prefixed. 
  
*/

class Solution {
     static boolean[][] dp;
     public boolean isMatch(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();
        // trivial cases 
        // if both string and pattern are empty, it's a match, else if only pattern is empty, it's not a match.
        if(lenP == 0){
            if(lenS == 0) return true;
            return false;
        }
        // pattern mustn't start with a '*'
        if(p.charAt(0) == '*') return false;
        // fill the matrix and assume the presence of '#' tokens prefixed, hence the len + 1 in the dimensions
        fillDP(s, p, lenS + 1, lenP + 1);
        // last cell holds the final result
        return dp[lenP][lenS];
    }
    
    static void fillDP(String s, String p, int sL, int pL){
        dp = new boolean[pL][sL];
        // empty string is matched by empty pattern
        dp[0][0] = true;
        // fill the first column accordingly
        for(int i = 2; i < pL; ++i){
                if(p.charAt(i-1) == '*') dp[i][0] = dp[i-1][0] || dp[i-2][0];
        }
        
        for(int i = 1; i < pL; ++i){
            for(int j = 1; j < sL; ++j){
                char symbol = p.charAt(i-1);
                char letter = s.charAt(j-1);
                // as described in the algo
                if(symbol == '*'){
                    if(p.charAt(i - 2) == '.' || p.charAt(i - 2) == letter) dp[i][j] = dp[i][j-1];
                    dp[i][j] = dp[i][j] || dp[i-1] || dp[i-2][j];
                    continue;
                }
                // if symbol matches with letter, check if there was a match excluding them
                if(symbol == '.' || symbol == letter) {
                    dp[i][j] = dp[i-1][j-1];
                    continue;
                }
            }
        }
    }
}
