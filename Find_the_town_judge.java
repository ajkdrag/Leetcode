/*
  Problem at : https://leetcode.com/problems/find-the-town-judge/
*/

class Solution {
    public int findJudge(int N, int[][] trust) {
        HashSet<Integer>[] arr = new HashSet[N + 1];
        for(int i = 1; i <= N; ++i){
            arr[i] = new HashSet<Integer>();
            arr[i].add(i);
        }
        for(int[] pair : trust){
            arr[pair[0]].add(pair[1]);
        }
        
        int judgeId = -1;
        for(int i = 1; i <= N; ++i){
            if(arr[i].size() == 1){
                judgeId = i;
                break;
            }
        }
        
        if(judgeId == -1)
            return judgeId;
        
        for(int i = 1; i <= N; ++i){
            if(!arr[i].contains(judgeId))
                return -1;
        }
        return judgeId;
    }
}


class Solution {
    public int findJudge(int N, int[][] trust) {
        if(null == trust || trust.length == 0) {
            if(N == 1)
                return 1;
            else
               return -1; 
        }
            
        int[] trustCount = new int[N+1];
        Arrays.fill(trustCount, 0);
        for(int[] pair : trust) {
            int source = pair[0];
            int destn = pair[1];                
            trustCount[source] = -1;
            trustCount[destn]++;
        }
        
        for(int i=0; i<=N; i++) {
            if(trustCount[i] == N-1)
                return i;
        }
        return -1;
    }
}


