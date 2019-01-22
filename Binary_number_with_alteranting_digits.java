/*
  Problem at : https://leetcode.com/problems/binary-number-with-alternating-bits/
*/

// clumsy version
class Solution {
    public boolean hasAlternatingBits(long n) {
        long s = n<<1;
        s += n;
        s >>= (n&1)^1;
        return (s&(s+1)) == 0 ? true : false;
    }
}

// better version of the above
class Solution {
    public boolean hasAlternatingBits(int n) {
        int s = 1 + n + (n >> 1);
        return (s & (s - 1)) == 0;
    }
}


