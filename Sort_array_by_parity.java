/*
  Problem at : https://leetcode.com/problems/sort-array-by-parity/
*/

class Solution {
    public int[] sortArrayByParity(int[] A) {
        int start = 0;
        for(int i = 0; i < A.length; ++i){
            if((A[i]&1) == 0){
                int temp = A[i];
                A[i] = A[start];
                A[start++] = temp;
            }
        }
        for(int i : A)
            System.out.println(i);
        return A;
    }
}


