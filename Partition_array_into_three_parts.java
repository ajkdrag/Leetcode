/*
  Problem at : https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/
*/

class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int len = A.length;
        int[] cum = new int[len];
        cum[0] = A[0];
        map.put(A[0], 0);
        for(int i = 1; i < len; ++i){
            cum[i] = cum[i-1] + A[i];
            map.put(cum[i], i);
        }
        int last = cum[len - 1];
        int first = -1;
        int mid = -1;
        for(int i = 0; i < len-1; ++i){
            first = cum[i];
            mid = (first + last)>>1;
            if((last != 3*first) || ((mid<<1) != (first + last)) || !map.containsKey(mid) || map.get(mid) < i ){
                continue;
            }
            return true;
        }
        return false;
    }
}


