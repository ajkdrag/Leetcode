/*
  Problem at : https://leetcode.com/problems/sum-of-square-numbers/
*/

class Solution {
    public boolean judgeSquareSum(int c) {
        for(int i = (int)Math.sqrt(c); i >= 0; --i){
            if(isPerfectSq(c - i*i))
                return true;
        }
        return false;
    }
    boolean isPerfectSq(int n){
        double sqrt = Math.sqrt(n);
        return sqrt == (int)sqrt;
    }
}

// using Fermat's theorem : https://wstein.org/edu/124/lectures/lecture21/lecture21/node2.html
// leetcode article : https://leetcode.com/problems/sum-of-square-numbers/solution/

public class Solution {
    public boolean judgeSquareSum(int c) {
        for (int i = 2; i * i <= c; i++) {
            int count = 0;
            if (c % i == 0) {
                while (c % i == 0) {
                    count++;
                    c /= i;
                }
                if (i % 4 == 3 && count % 2 != 0)
                    return false;
            }
        }
        return c % 4 != 3;
    }
}


