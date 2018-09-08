/*
  Input: "42" 
  Output: 42
  
  Input: "   -42"
  Output: -42
  
  Input: "4193 with words"
  Output: 4193
  
  Input: "-91283472332"
  Output: -2147483648
  
  First ignore all the whitespaces.
  Remember the sign by using a sign variable and simply "form" a number by appending the digits encountered.
  If the number exceeds Integer.MAX_VALUE we return Integer.MAX_VALUE.
  Note that here we define sign as follows : sign == 1 implies -ve and sign == 0 implies +ve number
  We use the fact that ASCII value of '+' = 43 and '-' = 45.
  Thus '+' - '+' = 0 and '-' - '+' = 2 
  Therefore by doing sign = ( character_val - '+') >> 1, we accordingly assign proper value to sign, without using if-else.
  After having formed the number, if sign == 0, return number as it is, otherwise negate and return
*/

class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        // trivial case of empty string
        if(n == 0) return 0;
        
        // start keeps track of the current index of the character we are scanning
        int start = 0;
        
        char[] str = s.toCharArray();
        // skip all the beginning whitespaces
        while(start < n && str[start] == ' ') start++;
        
        // if after skipping the whitespaces, the string has no more elements to scan i.e string was all whitespaces, return 0
        if(start == n) return 0;
        
        // c now holds the first non-whitespace character of the string
        char c = str[start];     
        // initialize sign to be +ve 
        int sign = 0;
        // set sign according to whether we have '-' or '+' in the string
        if(c == '-' || c == '+'){          
            sign = (c - '+')>>1;
            start++;
        }
        
        // start points to the first character that's neither a whitespace nor a sign (i.e '+' or '-')
        int max = Integer.MAX_VALUE/10;    
        // num holds the number which we form by appending all the digits we encounter consecutively
        int num = 0;
        
        while(start < n){
            c = str[start];
            // the moment we encounter a non-digit character, we break out of the loop
            // this also deals with the case when the 1st character (after - or +) is itself a non=digit character
            // as we haven't appended anything to 'num' yet, so it's 0 and 0 will be returned
            if(c < '0' || c > '9') break;
            // if we got past the if- condition, it implies that the character is a digit, so we get it's value
            int digit = c - '0';
            // before appending this digit, check whether the number formed doesn't exceed the max value
            // note that Integer.MIN_VALUE and Integer.MAX_VALUE have the same absolute values except for the fact
            // that Integer.MIN_VALUE has 8 as it's last digit while Integer.MAX_VALUE has 7 as it's last digit
            // Also note that Integer.MAX_VALUE + 1 = Integer.MIN_VALUE
            if(num > max || (num == max && digit > 7 + sign)) return Integer.MAX_VALUE + sign;    
            // append the digit to num and keep scanning the remaining string
            num = num*10 + digit;
            start++;
        }
        
        return num with appropriate sign
        return sign == 0 ? num : -num;
	
    }
}
