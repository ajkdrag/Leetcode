/*
  Method 1: Some micro optimizations over method 2
*/

class Solution {
     public int reverse(int x) {
        // check if the number is the smallest negative number possible, if yes, then return 0
        // this serves two purposes :
        // 1. The 2's complement of the smallest negative number gives the same number itself (in -ve form)
        // 2. The reverse of the smallest negative number for integer data type overflows, so we return 0 anyway.
        if(x << 1 == 0) return 0;    
        
        // sign stores whether the number is -ve or +ve
        int sign = 1;
        int res = 0;
        // make the negative number positive and then reverse it, but remember the original sign
        if(x < 0){
            x = -x;
            sign = -1;
        }
        // in order to avoid checking for overflow in every iteration, we iterate till the final digit is to be reversed
        // and before adding that final digit to the reversed number, we make sure that we don't overflow
        int limit = Integer.MAX_VALUE/10;
        while(x > 9){  
            res = res*10 + (x%10);
            x = x/10;          
        }
        // if overflow, return 0
        if(res > limit) return 0;        
        // else append that final digit to the reversed number and return with proper sign
        return sign*(res*10 + x);
    }
}


/*
  Method 2: Short and simple
*/

class Solution {
      public int reverse(int x) {
         // same check as in method 1
         if(x << 1 == 0) return 0;       
         int res = 0;
         int limit = Integer.MAX_VALUE/10;
         // here we don't deal with -ve and +ve overflows inside the loop unlike method 1
         // hence, no need for using "absolute" value and sign variable
         while(x!= 0){  
             if(res > limit || res < -limit) return 0;
             res = res*10 + (x%10);
             x = x/10;          
         }
         return res;
     }
}
