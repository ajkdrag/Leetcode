/*
  Problem at : https://leetcode.com/problems/triples-with-bitwise-and-equal-to-zero/
*/

class Solution {
    int n = 16;
    public int countTriplets(int[] A) {
        int len = A.length;
        long res = len*len*len;
        for(int i = 1; i < (1 << n); ++i){
            int ct = 0;
            int num1 = 0;
            for(int j = 0; j < len; ++j){
                int num = A[j];
                int k = i;
                int bitCt = 0;
                int oneCt = 0;
                boolean fnd = true;
                while(k > 0){
                    if((k&1)>0){
                        ++oneCt;
                        num1 = oneCt > num1 ? oneCt : num1;
                        if((num&(1<<bitCt))==0){
                            fnd = false;
                            break;
                        }
                    }
                    k >>= 1;
                    ++bitCt;
                }
                ct += (fnd ? 1 : 0);
            }
            if((num1&1)==0)
                res += (ct*ct*ct);
            else
                res -= (ct*ct*ct);
        }
        return (int)res;
    }
}


