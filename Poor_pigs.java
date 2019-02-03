/*
  Problem at : https://leetcode.com/problems/poor-pigs/
  Solution explained at : https://leetcode.com/problems/poor-pigs/discuss/94266/Another-explanation-and-solution
*/

class Solution {
    int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
      return (int) Math.ceil(Math.log(buckets)/Math.log(minutesToTest/minutesToDie+1));
    }
}

