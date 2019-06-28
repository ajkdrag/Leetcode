/*
  Problem at : https://leetcode.com/problems/subarray-sums-divisible-by-k/
*/

class Solution {
    public int subarraysDivByK(int[] A, int K) {
        HashMap<Integer, Integer> modCount = new HashMap<Integer, Integer>();
        int N = A.length;
        int val = (K + A[0]%K)%K;
        A[0] = val;
        modCount.put(val, 1);
        int res = val == 0 ? 1 : 0;
        for(int i = 1; i < N; ++i){
            val = (A[i-1] + A[i]%K + K)%K;
            A[i] = val;
            int curr = modCount.getOrDefault(val, 0) + 1;
            res += curr + (val == 0 ? 0 : -1);
            modCount.put(val, curr);
        }
        return res;
    }
}


