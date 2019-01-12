/*
  Problem : https://leetcode.com/problems/delete-columns-to-make-sorted/
*/

class Solution {
    public int minDeletionSize(String[] A) {
        int count = 0;
        for (int i = A[0].length() - 1; i >= 0; --i) {
            for (int j = A.length - 2; j >= 0; --j) {
                if (A[j+1].charAt(i) < A[j].charAt(i)) {
                    count++;
                    break;
                }
            }
         }
        return count;
    }
}


