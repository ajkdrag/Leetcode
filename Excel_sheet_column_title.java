/*
  Problem at : 
*/

// recursive solution
class Solution {
    public String convertToTitle(int n) {
        return helper(n);
    }
    
    public String helper(int n){
        if(n == 0)
            return "" + 'Z';
        if(n <= 26)
            return "" + (char)('A' + n - 1);
        if(n % 26 == 0){
            return helper(n/26 - 1)  + 'Z';
        }
        return helper(n/26) + (char)('A' + (n%26) - 1);
    }
}

// iterative solution
class Solution {
    public String convertToTitle(int n) {
        if (n <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            char ch = (char)('A' + n % 26);
            sb.append(ch);
            n /= 26;
        }
        return sb.reverse().toString();
    }
}


