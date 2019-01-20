/*
  Problem at : https://leetcode.com/problems/arithmetic-slices/
  Detailed solutions at : https://leetcode.com/problems/arithmetic-slices/solution/
*/

class Solution {
    static int numberOfArithmeticSlices(int[] A) {
        int i = 0;
        int n = A.length - 1;
        int total = 0;
        while(i < n - 1){
            int count = 0;
            while(A[i] + A[i + 2] == ((A[i + 1])<<1)){
                ++count;
                ++i;
                if(i >= n - 1)
                    break;
            }
            total += ((count)*(count + 1))>>1;
            ++i;
        }
        return total;
    }
}


