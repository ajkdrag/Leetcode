/*
  Problem at : https://leetcode.com/problems/reverse-bits/
*/

public class Solution {
    public int reverseBits(int n) {
        int rev = 0;
        int num = 0;
        while(n != 0){
            rev<<=1;
            rev |= (n&1);
            n>>>=1;
            ++num;
        }
        rev<<=(32 - num);
        return rev;
    }
}


