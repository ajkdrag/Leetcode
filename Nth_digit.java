/*
  Problem at : https://leetcode.com/problems/nth-digit/
*/

class Solution {
    public int findNthDigit(int n) {
        if(n < 10)
            return n;
        int len = 1;
		long count = 9;
		int start = 1;
		while (n > len * count) {
			n -= len * count;
			len += 1;
			count *= 10;
			start *= 10;
		}
        n--;
        int num = n/len;
        int pos = len - 1 - (n%(len));
        int res = start + num;
        while(pos-- > 0){
            res /= 10;
        }
        return res%10;
    }
}


