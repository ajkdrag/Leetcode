/*
  Problem at : https://leetcode.com/problems/monotonic-array/
*/

class Solution {
    public boolean isMonotonic(int[] A) {
        int n = A.length;
        if(n < 3)
            return true;
        int i = 1;
        while(i < n && A[i] == A[i - 1])
            ++i;
        if(i == n)
            return true;
        int diff = A[i] - A[i - 1];
        if(diff > 0){
            while(++i < n){
                if(A[i] - A[i - 1] < 0)
                    return false;
            }
        }
        else {
            while(++i < n){
                if(A[i] - A[i - 1] > 0)
                    return false;
            }
        }
        return true;
    }
}


