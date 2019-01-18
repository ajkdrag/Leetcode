/*
  Problem at : https://leetcode.com/problems/number-complement/
*/

class Solution {
    public int findComplement(int num) {
        int res = 0;
        int bit = 1;
        while(num > 0){
            if((num & 1) == 0)
                res |= bit;
            bit <<= 1;
            num >>= 1;
        }
        return res;
    }
}


