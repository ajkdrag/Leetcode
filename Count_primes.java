/*
  Problem at : https://leetcode.com/problems/count-primes/
*/

class Solution {
    public int countPrimes(int n) {
        if(n <= 2)
            return 0;
        if(n <= 3)
            return 1;
        int[] sieve = new int[n];
        int count = 0;
        for(int i = 3; i < n; i+=2){
            if(sieve[i] == 0){
                ++count;
                for(int j = (i<<1) + i; j < n; j += (i<<1))
                    sieve[j] = 1;
            }
        }
        return count+1;
    }
}


