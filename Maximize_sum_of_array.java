/*
  Problem at : https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/
*/

class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        int[] temp = new int[101];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 0;
        int min = Integer.MAX_VALUE;
        int res = 0;
        
        for(int i : A){
            if(i < 0){
                temp[i + 100] = (-i);
                map.put(-i, 1 + map.getOrDefault(-i, 0));
                ++count;
                min = -i < min ? -i : min;
                res += (-i);
            }
            else {
                min = i < min ? i : min;
                res += i;
            }
        }
        
        int left = K - count;
        if(count <= K){
            if((left&1) == 0)
                return res;
            else
                return res - (min<<1);
        }
        
        else {
            left *= -1;
            for(int i = 100; i >= 0 && left > 0; --i){
                if(temp[i] != 0){
                    int times = map.get(temp[i]);
                    if(times >= left){
                        res -= ((temp[i]*left)<<1);
                        left -= times;
                        continue;
                    }
                    res -= ((temp[i]*times)<<1);
                    left -= times;
                }
            }
        }
        return res;
    }
}


