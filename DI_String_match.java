/*
  Problem at : https://leetcode.com/problems/di-string-match/
  Solution at (Different from one presented here) : https://leetcode.com/problems/di-string-match/solution/
*/

class Solution {
    public int[] diStringMatch(String S) {
        int N = S.length();
        int[] pool = new int[N + 1];
        for(int i = 0; i <= N; ++i){
            pool[i] = i;
        }
        int poolHeader = 0;
        for(int i = 0; i < N; ++i){
            if(S.charAt(i) == 'I'){
                poolHeader = i + 1;
            }
            else {
                for(int j = i + 1; j > poolHeader; --j){
                    int temp = pool[j];
                    pool[j] = pool[j - 1];
                    pool[j - 1] = temp;
                }
            }
        }
        return pool;
    }
}


