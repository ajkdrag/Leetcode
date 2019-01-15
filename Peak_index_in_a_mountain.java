/*
  Problem at : https://leetcode.com/problems/peak-index-in-a-mountain-array/
*/

// non concise solution
class Solution {
    public static int peakIndexInMountainArray(int[] A) {
        int start = 0;
        int end = A.length - 1;
        if(end - start == 1){
            return A[0] > A[1]? 0 : 1;
        }
        
        while(start < end){
            int mid = (start + end)>>1;
            if(A[mid - 1] >= A[mid] && A[mid] >= A[mid + 1]){
                end = mid;
            }
            else if(A[mid - 1] <= A[mid] && A[mid] <= A[mid + 1])
                start = mid;
            else 
                return mid;
        }
        return start;
    }
}

// concise
class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int lo = 0, hi = A.length - 1;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (A[mi] < A[mi + 1])
                lo = mi + 1;
            else
                hi = mi;
        }
        return lo;
    }
}


