/*
  Problem at : https://leetcode.com/problems/power-of-three/
  Solution at : https://leetcode.com/problems/power-of-three/solution/
*/

// Log method
class Solution {
    public boolean isPowerOfThree(int n) {
        if(n <= 0)
            return false;
        int d =(int) Math.ceil(Math.log(n)/Math.log(3));
        System.out.println(d);
        return Math.pow(3, d) == n;
    }
}

// Power method
public class Solution {
    public boolean isPowerOfThree(int n) {
        // 1162261467 is 3^19,  3^20 is bigger than int  
        return ( n>0 &&  1162261467%n==0);
    }
}


