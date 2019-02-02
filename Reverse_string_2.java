/*
  Problem at : https://leetcode.com/problems/reverse-string-ii/
*/

class Solution {
    public String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        int len = a.length;
        for (int start = 0; start < len; start += 2 * k) {
            int i = start, j = i + k < len ? i + k - 1 : len - 1;
            while (i < j) {
                char tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        return new String(a);
    }
}


