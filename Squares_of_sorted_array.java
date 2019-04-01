/*
  Problem at : https://leetcode.com/problems/squares-of-a-sorted-array/
*/

// 2 pointer solution with extra O(n) space
class Solution {
    public int[] sortedSquares(int[] A) {
        int len = A.length;
        int[] result = new int[len];
        int i = 0;
        int j = len - 1;
        int k = len - 1;
        int first = -1;
        int second = -1;
        int firstSq = -1;
        int secondSq = -1;
        while(i <= j){
            first = A[i];
            second = A[j];
            firstSq = first*first;
            secondSq = second*second;
            if(firstSq > secondSq){
                result[k--] = firstSq;
                ++i;
                continue;
            }
            else{
                result[k--] = secondSq;
                --j;
            }
        }
        return result;
    }
}


