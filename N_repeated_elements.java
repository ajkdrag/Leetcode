/*
  Problem at : https://leetcode.com/problems/n-repeated-element-in-size-2n-array/
  Solution : https://leetcode.com/problems/n-repeated-element-in-size-2n-array/discuss/208563/JavaC%2B%2BPython-O(1)-Solution
  Basically, since we have N+1 unique elements in an array of size 2N and exactly one element is repeated N times, it implies that
  only one element is repeated, while others remain distinct. This also means that if we have N repeated numbers, then atleast two
  of them will be apart by no more than one different element. Example : 'O' is the duplicated element and 'X','Y', the distinct elements;
  O, X, O, Y, O, O ... is possible, but --> O, X, Y, O, Z, A, O,.. is not possible. Here is the proof.
  
  We have N duplicates, and we want to separate each of them by 2 distinct elements. Thus : O _ _ O _ _ O _ _ O ...  (N - 1)*2 spaces
  are created to be filled by 'N' elements (we had N + 1 unique elements of which one is O, thus, remainder is N).
  ==> 2N - 2 = N
  ==> N = 2
  i.e for any value of N, except 2, it is proved that every pair of duplicates can't be apart by 2 other elements... in other words,
  there is atleast one consecutive duplicate pair, that's not apart by 2 elements. i.e Check if A[i] == A[i - 1] or A[i] == A[i - 2]
  If so, we return A[i]. Now for the edge case of N = 2, we can only have the following cofig : O, X, Y, O , separating the two 
  duplicates by 2 elements. In this case, the answer is either A[0] or A[3].
*/

class Solution {
    public int repeatedNTimes(int[] A) {
        for (int i = 2; i < A.length; ++i)
            if (A[i] == A[i - 1] || A[i] == A[i - 2])
                return A[i];
        return A[0];
    }
}
    
// For the case when it is only specified that there are N repeated elements in an array of size 2N
// and the condition that there are N+1 unique elements in relaxed. We have this solution :
// In this case, after sorting, the chain of N duplicates lies either in 1st half or 2nd entirely or crosses the median.
// We check for these 3 cases and return accordingly. This solution works for the above as well.

class Solution {
    public int repeatedNTimes(int[] A) {
        Arrays.sort(A);
        int N = A.length >> 1;
        if(A[N] == A[N-1]) return A[N];
        else if(A[0] == A[N-1]) return A[0];
        else return A[N];
    }
}

