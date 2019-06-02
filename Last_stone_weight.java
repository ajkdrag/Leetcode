/*
  Problem at : https://leetcode.com/problems/last-stone-weight/
*/

// use of priority queue
class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer i, Integer j) {
                return j - i;
            }
        });
        for (int i : stones) {
            queue.offer(i);
        }
        while (queue.size() > 1) {
            int i = queue.poll();
            int j = queue.poll();
            if (i != j) {
                queue.offer(i - j);
            }
        }
        return queue.size() == 1 ? queue.poll() : 0;
    }
}


