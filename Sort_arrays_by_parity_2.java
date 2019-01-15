/*
  Problem at : https://leetcode.com/problems/sort-array-by-parity-ii/
*/

// not so concise
class Solution {
    public static int[] sortArrayByParityII(int[] A) {
        int N = A.length;
        int i = 0;
        int j = 1;
        int limit_i = N-2;
        int limit_j = N-1;
        while(i <= limit_i){
            while(i <= limit_i && (A[i]&1)==0){
                i+=2;
            }
            while(j <= limit_j && (A[j]&1)==1){
                j+=2;
            }
            if(i > limit_i)
                return A;
            if(j > limit_j)
                return A;
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
        return A;
    }
}

// concise
class Solution {
    public int[] sortArrayByParityII(int[] A) {
    //use 2 pointers
        int x = 0, y = 1;
        int len = A.length;
        int temp = 0;
        while(x <= len - 2 && y <= len - 1){
            int val = A[x];
            if((val&1) == 1){
                temp = A[y];
                A[y] = val;
                A[x] = temp;
                y+=2;
            }else{
                x+=2;
            }
        }
        return A;
    }
}


