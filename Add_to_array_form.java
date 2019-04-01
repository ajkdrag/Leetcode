/*
  Problem at : https://leetcode.com/problems/add-to-array-form-of-integer/
*/

class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int cur = K;
        List<Integer> ans = new ArrayList();
        int i = A.length;
        while (--i >= 0 || cur > 0) {
            if (i >= 0)
                cur += A[i];
            ans.add(cur % 10);
            cur /= 10;
        }
        Collections.reverse(ans);
        return ans;
    }
}


