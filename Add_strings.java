/*
  Problem at : https://leetcode.com/problems/add-strings/
*/

public class Solution {
    public String addStrings(String num1, String num2) {
        int l1 = num1.length(), l2 = num2.length();
        char[] ans = new char[Math.max(l1, l2) + 1];
        int carry = 0;
        int i = l1 - 1, j = l2 - 1, k = ans.length - 1;
        while (k >= 0) {
            int x = (i >= 0) ? num1.charAt(i--) - '0' : 0;
            int y = (j >= 0) ? num2.charAt(j--) - '0' : 0;
            int z = x + y + carry;
            ans[k--] = (char) (z % 10 + '0');
            carry = z >= 10 ? 1 : 0;
        }
        if (ans[0] > '0') return String.valueOf(ans);
        return String.valueOf(ans, 1, ans.length - 1);
    }
}


