/*
  Problem at : 
*/

// iterative
class Solution {
    public String strWithout3a3b(int A, int B) {
        StringBuilder sb = new StringBuilder(A + B);
        while (A + B > 0) {
            String s = sb.toString();
            if (s.endsWith("aa")) {
                sb.append("b");
                --B;       
            }else if (s.endsWith("bb")){
                sb.append("a");
                --A;
            }else if (A > B) {
                sb.append("a");
                --A;
            }else {
                sb.append("b");
                --B;
            }
        }
        return sb.toString();
    }
}

// recursive
class Solution {
    public String strWithout3a3b(int A, int B) {
        if (A == 0 || B == 0) {
            StringBuilder sb = new StringBuilder();
            while(A-- > 0)
                sb.append('a');
            while(B-- > 0)
                sb.append('b');
            return sb.toString();
        }
        if (A == B) { return "ab" + strWithout3a3b(A - 1, B - 1); }
        if (A > B) { return "aab" + strWithout3a3b(A - 2, B - 1); }
        return "bba" + strWithout3a3b(A - 1, B - 2);
    }
}



