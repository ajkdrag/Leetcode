/*
  Problem at : https://leetcode.com/problems/optimal-division/
  Solutions at : https://leetcode.com/problems/optimal-division/solution/
*/

//  X1/X2/X3/../Xn will always be equal to (X1/X2) * Y, no matter how we place parentheses. i.e no matter how we place parentheses, 
//  X1 always goes to the numerator and X2 always goes to the denominator. Hence we just need to maximize Y. 
//  Y is maximized when it is equal to X3 *..*Xn. So the answer is always X1/(X2/X3/../Xn) = (X1 *X3 *..*Xn)/X2

class Solution {
    public String optimalDivision(int[] nums) {
        int n = nums.length;
        if( n <= 2 ) return nums[0] + ( (n == 2) ? ( "/"+nums[1] ) : "" );
        StringBuilder retVal = new StringBuilder( nums[0] + "/("+nums[1] );
        for( int i=2; i < n; i++ ) 
            retVal.append( "/"+nums[i] );
        return retVal.toString()+")";
    }
}


