 /*
  Check if a number is a palindrome or not, without turning it into a string
  Note: It's mentioned that numbes like : -121 are not palindromes since reverse of (-121) is (121-) which isn't same as original input.
  
  Basic algo : 
  Negative numbers always have that hyphen, so they will not be palindromes.
  Reverse the number by basic algo of getting last digits and appending them to form the reversed number : 
    rev = 0 ; 
    rev = rev*10 + x%10 ;
    x /= 10 ;
  and check if original number is equal to reversed number or not.
*/

class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        if(x < 10) return true;
        int orig = x;
        int rev = 0;
        while(x > 0){
            rev = rev*10 + x%10;
            x/=10;
        }
        return orig == rev;
    }
}
