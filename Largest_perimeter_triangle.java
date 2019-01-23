/*
  Problem at : https://leetcode.com/problems/largest-perimeter-triangle/
*/

class Solution {
    public int largestPerimeter(int[] A) {
        int i = A.length - 1;
        Arrays.sort(A);
        for(; i >= 2; --i){
            if(A[i] < A[i-1] + A[i-2])
                return A[i] + A[i - 1] + A[i - 2];
        }
        return 0;
    }
}


