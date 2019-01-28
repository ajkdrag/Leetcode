/*
  Problem at : https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
  Solution at : https://leetcode.com/problems/minimum-moves-to-equal-array-elements/discuss/93817/It-is-a-math-question
*/

class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for(int el : nums){
            min = el < min ? el : min;
            res += el;
        }
        return res - min*nums.length;
    }
}


