/*
  Problem at : https://leetcode.com/problems/flipping-an-image/
*/

class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int len = A[0].length - 1;
        for(int[] rows : A){
            helper(rows, 0, len);
        }
        return A;
    }
    
   void helper(int arr[], int start, int end) 
    { 
        int temp; 
        while (start <= end) 
        { 
            if(arr[start] == arr[end]){
                arr[end] = arr[start] ^= 1;
            }
            ++start;
            --end;
        }
    }    
}


