/*
  Problem at : https://leetcode.com/problems/reach-a-number/
  Solution at : https://leetcode.com/problems/reach-a-number/solution/
*/

class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int k = 0;
        while (target > 0)
            target -= ++k;
        return (target & 1) == 0 ? k : k + 1 + (k&1);
    }
}


