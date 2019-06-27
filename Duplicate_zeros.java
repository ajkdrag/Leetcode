/*
  Problem at : https://leetcode.com/problems/duplicate-zeros/
*/

class Solution {
    public void duplicateZeros(int[] arr) {
        Queue<Integer> q = new LinkedList<Integer>();
        int n = arr.length;
        if(arr[0] == 0)
            q.offer(0);
        for(int i = 0; i < n; ++i){
            int temp = arr[i];
            if(!q.isEmpty()){
                arr[i] = q.poll();
                q.offer(temp);
            }
            if(i+1 < n && arr[i+1] == 0){
                q.offer(0);
            }
        }
    }
}


