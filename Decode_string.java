/*
  Problem at : https://leetcode.com/problems/decode-string/
*/

// iterative
class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack<String>();
        String res = "";
        for(char c : s.toCharArray()){
            if(c != ']'){
                st.push(Character.toString(c));
                continue;
            }
            
            if(c == ']'){
                String temp = "";
                while(!st.peek().equals("[")){
                    temp = st.pop() + temp;
                }
                
                st.pop();
                int times = 0;
                int place = 1;
                while(!st.isEmpty() && Character.isDigit(st.peek().charAt(0))){
                    times = (st.pop().charAt(0) - '0')*place + times;
                    place *= 10;
                }
                res = "";
                while(times-- > 0)
                    res += temp;
                st.push(res);
            }
        }
        res = "";
        for(String ss : st)
            res += ss;
        return res;
    }
}

// recursive
class Solution {

      public String decodeString(String s) {
    if (s.length() == 1) {
      return s;
    }

    StringBuilder out = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
      char curr = s.charAt(i);
      if (Character.isLetter(curr)) {
        out.append(curr);
      } else {
        StringBuilder digits = new StringBuilder();
        while (Character.isDigit(curr)) {
          digits.append(curr);
          i++;
          curr = s.charAt(i);
        }

        int closeIndex = i + findBracketMatch(s.substring(i));

        int reps = Integer.parseInt(digits.toString());
        String innerString = decodeString(s.substring(i+1, closeIndex));
        while (reps-- > 0) {
          out.append(innerString);
        }
        i = closeIndex;
      }
    }

    return out.toString();
  }

  public int findBracketMatch(String s) {
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      char curr = s.charAt(i);
      if (curr == '[') {
        count++;
      } else if (curr == ']') {
        count--;
      }
      if (count == 0) {
        return i;
      }
    }
    return -1;
  }
}


