/*
  Problem at : https://leetcode.com/problems/self-dividing-numbers/
*/

// Brute-force solution
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (valid(i)) {
                res.add(i);
            }
        }
        return res;
    }
    public boolean valid(int num) {
        int cur = num;
        while (cur != 0) {
            int digit = cur % 10;
            if (digit == 0 || num % digit != 0) {
                return false;
            }
            cur /= 10;
        }
        return true;
    }
}


