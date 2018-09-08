 /*
  Check if a number is a palindrome or not, without turning it into a string
  Note: It's mentioned that numbes like : -121 are not palindromes since reverse of (-121) is (121-) which isn't same as original input.
  
  Basic algo : 
  Negative numbers always have that hyphen, so they will not be palindromes.
  Reverse half the number by basic algo of getting last digits and appending them to form the reversed number : 
    rev = 0 ; 
    rev = rev*10 + x%10 ;
    x /= 10 ;
  and check if first half is equal to reversed half or not.
  Note that for numbers with even length like : 1221, the first half and reversed half are of same lengths
  but for numbers with odd length like : 12321, the first half will be 12 and reversed half will become 123,
  Thus we need to divide reversed half by 10, since for palindromes of odd-length, middle digit doesn't matter anyway.
*/

class Solution {
    public boolean isPalindrome(int x) {
        // negative number case (eg: -121)
        if(x < 0) return false;
        // singe digit case (eg: 3, 7 ,9)
        if(x < 10) return true;
        // numbers that end in 0 are not palindromes (eg: 10, 100, 30, etc)
        if(x % 10 == 0) return false;
    
        int rev = 0;
        while(x > rev){
            rev = rev*10 + x%10;
            x/=10;
        }
        return x == rev || x == rev/10;
    }
}
