/*
  Problem at : https://leetcode.com/problems/complement-of-base-10-integer/
*/

class Solution {
    public int bitwiseComplement(int N) {
        int res = 0;
        int index = 0;
        int last = 0;
        if(N == 0)
            return 1;
        while(N > 0){
            last = (N&1);
            last ^= 1;
            res |= (last<<index);
            index++;
            N>>=1;
        }
        return res;
    }
}


