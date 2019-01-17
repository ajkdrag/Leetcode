/*
  Problem at : https://leetcode.com/problems/shortest-distance-to-a-character/
*/

class Solution {
    public int[] shortestToChar(String S, char C) {
        int N = S.length();
        int[] output = new int[N];
        int next = S.indexOf(C);
        int prev = -1;
        for (int i = 0; i < N; i++) {
            if (next == -1){
                output[i] = i - prev;
            }
            else if (prev != -1) {
                output[i] = (int) Math.min(i - prev, next - i);
            }
            else {
                output[i] = next - i;
            }
            if (i == next && next < N-1) {
                output[i] = 0;
                int temp = S.indexOf(C, next+1);
                prev = next;
                if (temp != -1) {
                    next = temp;
                }
                else
                    next = -1;
            }
        }
        return output;
    }
}


