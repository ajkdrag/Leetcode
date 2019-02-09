/*
  Problem at : https://leetcode.com/problems/perfect-number/
*/

public class Solution {
    public boolean checkPerfectNumber(int num) {
        int[] primes=new int[]{2,3,5,7,13,17,19,31};
        for (int p: primes) {
            if ((1 << (p - 1)) * ((1 << p) - 1) == num)
                return true;
        }
        return false;
    }
}


