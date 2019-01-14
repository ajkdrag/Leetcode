/*
  Problem at : https://leetcode.com/problems/k-closest-points-to-origin/
*/

// Priority Queue based solution
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int N = points.length;
        int[] dists = new int[N];
        PriorityQueue<Integer> pq = new PriorityQueue<>(N, new Comparator<Integer>(){
           public int compare(Integer a, Integer b){
               if(dists[a] > dists[b]) 
                   return 1;
               else if(dists[a] < dists[b]) 
                   return -1;
               return 0;
           }
        });
        for(int i = 0; i < N; ++i){
            int x = points[i][0];
            int y = points[i][1];
            dists[i] = x*x + y*y;
            pq.add(i);
        }
        int[][] res = new int[K][2];
        for(int i = 0; i < K; ++i){
            res[i] = points[pq.poll()];
        }
        return res;
    }
}


