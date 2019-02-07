/*
  Problem at : https://leetcode.com/problems/add-binary/
*/

public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append((sum&1) == 0 ? 0 : 1);
            carry = sum >>1;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}


