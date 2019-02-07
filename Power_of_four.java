/*
  Problem at : https://leetcode.com/problems/power-of-four/
*/

// log method
class Solution {
    public boolean isPowerOfFour(int num) {
        double val = Math.log(num)/Math.log(4);
        if(val == (int) val)
            return true;
        return false;
    }
}

// 'java' method
public boolean isPowerOfFour(int num) {
    return Integer.bitCount(num) == 1 
       && (Integer.numberOfLeadingZeros(num) & 1) == 1;
}

// bit twiddling
public boolean isPowerOfFour(int num) {
    return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
    //0x55555555 is to get rid of those power of 2 but not power of 4
    //so that the single 1 bit always appears at the odd position 
}

