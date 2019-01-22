/*
  Problem at : https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/
*/

class Solution {
    public int countPrimeSetBits(int L, int R) {
        int res = 0;
        for(int i = L; i <= R; ++i){
            if(isPrime(Integer.bitCount(i)))
                ++res;
        }
        return res;
    }

    boolean isPrime(int n) {
        if(n == 2 || n == 3 || n == 5 || n == 7 || n== 11 || n == 13 || n == 17 || n == 19)
            return true;
        return false;
    }
}


