/*
  Problem at : https://leetcode.com/problems/hamming-distance/
*/

class Solution {
    int hammingDistance(int x, int y) {
        int res = x^y;
        int count = 0; 
        while (res > 0) { 
            res &= (res - 1) ; 
            ++count; 
        } 
        return count;
    }
}


