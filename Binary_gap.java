/*
  Problem at : https://leetcode.com/problems/binary-gap/
*/

class Solution {
    public int binaryGap(int N) {
        int last = -1, res = 0;
        int place = 0;
        while(N > 0){
            if((N&1) == 1){
                int curr = place - last;
                if(last != -1 && curr > res){
                    res = curr;
                }
                last = place;
            }
            ++place;
            N>>=1;
        }
        return res;
    }
}


