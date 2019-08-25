/*
  Problem at : https://leetcode.com/problems/triples-with-bitwise-and-equal-to-zero/
*/

// inclusion - exclusion
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

// inclusion - exclusion (better implementation)
class Solution {
    public int countTriplets(int[] A) {
        int ans = 0;
        int N = A.length;
        for(int k = 1; k < (1 << 16); k++) {
            int count = 0;
            for(int i = 0; i < N; i++) {
                if((A[i] & k) == k) count++;
            }
            String s = Integer.toString(k, 2);
            int c = 0;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '1') c++;
            }
            if(c % 2 == 1) ans += count * count * count;
            else ans -= count * count * count;
        }
        return N*N*N - ans;
    }
}

