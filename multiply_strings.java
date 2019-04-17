/*
  Problem at : https://leetcode.com/problems/multiply-strings/
  Solution at : https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation
*/

class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        if((m == 1 && num1.charAt(0) == '0') || (n == 1 && num2.charAt(0) == '0'))
            return "0";
        int[] pos = new int[m + n];
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int sum = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + pos[i + j + 1];
                // for carry
                pos[i + j] += sum / 10;
                // for digit
                pos[i + j + 1] = (sum) % 10;
            }
        }  

        StringBuilder sb = new StringBuilder();
        for(int p : pos) 
            if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.toString();
    }
}


