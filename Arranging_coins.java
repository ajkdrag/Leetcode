/*
  Problem at : https://leetcode.com/problems/arranging-coins/
*/

class Solution {
    public int arrangeCoins(long n) {
        int temp = (-1 + (int)Math.sqrt(1 + n<<3))>>1;
        return temp;
    }
}


