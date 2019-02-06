/*
  Problem at : https://leetcode.com/problems/maximize-distance-to-closest-person/
*/

class Solution {
    public int maxDistToClosest(int[] seats) {
        int len = seats.length;
        int last = -1;
        if(seats[0] == 1)
            last = 0;
        int max = -1;
        for(int i = 1; i < len; ++i){
            int curr = seats[i];
            if(curr == 1){
                int dist = (last == -1 ? i : (i - last)>>1);
                max = max < dist ? dist : max;
                last = i;
            }
        }
        max = max < len - 1 - last ? len - 1 - last : max;
        return max;
    }
}


