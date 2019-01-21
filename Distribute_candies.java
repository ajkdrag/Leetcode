/*
  Problem at : https://leetcode.com/problems/distribute-candies/
*/

class Solution {
    public int distributeCandies(int[] candies) {
        HashSet<Integer> set = new HashSet<>();
        int N = candies.length;
        set.add(candies[N - 1]);
        int count = 1;
        int lim = N>>1;
        for(int i = candies.length - 2 ; i >= 0 && set.size() != lim; --i){
           set.add(candies[i]);
        }
        return set.size();
    }
}


