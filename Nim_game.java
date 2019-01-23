/*
  Problem at : https://leetcode.com/problems/nim-game/
  Solution at : https://leetcode.com/problems/nim-game/solution/
*/

class Solution {
    public boolean canWinNim(int n) {
        return (n&(3)) != 0;
    }
}


