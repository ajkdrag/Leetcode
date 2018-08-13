// Given a string s, find the longest palindromic substring in it.

// Method 1: O(n^2) in time and space

// In this approach we use Dynamic Programming
// suppose we have a string "abbb", lets say k = diff between i and j where i,j are start and end indices of a substring
// eg if i = 0, j = 2, k = j-i = 2;
// we check if (k+1)-lengthed substrings are palindrome or not (using DP) (1 <= k <= n-1)
// we don't need to start from 0, since each element by itself is already a palindrome (k == 0 gives elements like "a,b...")
// for k = 1, we only need to check if the two elements are equal or not (k == 1 gives elements like "ab,bb...")
// for k = 2, we only need to check if extreme two are equal or not (k == 2 gives elements like "abb,bbb...")
// for k > 2, we need to check if extreme two are equal && inner substring i.e (k-2) is palindrome or not (eg. abba)
// to keep a track of results from previous k-values, we maintain a 2D array
// dp[i][j] == 1 implies that substring starting at index i and ending at index j is a palindrome

/* eg: s = "abbb"
   procedure is to fill the elements diagonally top-left to bottom-right
   each diagonal sort of represents 'k value' the longest diagonal representing k = 0 (which we may not fill since it's trivial)
   subsequent diagonals get filled in the correspoding to the k-values
   if s[i] == s[j] , and k <= 2 we set dp[i][j] = 1 since substring s[i,j] is a palindrome
   if s[i] == s[j] , and k > 2, we check if dp[i+1][j-1] == 1, if yes, then set dp[i][j] = 1 , i.e a palindrome
   note that dp[i+1][j-1] corresponds to k-2 as it was filled when k-value was k-2
   
   ## Initial state
       a b b b
    a |0|0|0|0|
    b |0|0|0|0|
    b |0|0|0|0|
    b |0|0|0|0| 
    
    ## k = 0
       a b b b
    a |1|0|0|0|
    b |0|1|0|0|
    b |0|0|1|0|
    b |0|0|0|1| 

    ## k = 1
       a b b b
    a |1|0|0|0|
    b |0|1|1|0|
    b |0|0|1|1|
    b |0|0|0|1|  
    
    ## k = 2 
       a b b b
    a |1|0|0|0|
    b |0|1|1|1|
    b |0|0|1|1|
    b |0|0|0|1| 
  
    ## k = 3 will be the same since 'a' and 'b' don't match.
    Now, whenever we place a '1' in any location, we make sure to store the i and j values so that at the end we can get the answer
    This is the case because we are interested in the longest palindromic subsequence and we are increasing the k-values
    (i.e bottom up approach) hence, whenever we place a '1' in any location, we have found the longest palindromic subsequence so far
*/

class Solution {
    public String longestPalindrome(String str) {
        
        // convert the string to a character array for faster access
        // (faster for large inputs as evident from the runtime as shown on leetcode)
        // string.charAt() uses less code and is simpler but is somewhat slower (probably for larger inputs)
        int n = str.length();
        char[] s = str.toCharArray();
        // trivial case
        if(n < 2) return str;
        // use a byte array to save space, if possible use an even shorter data type
        byte[][] dp = new byte[n][n];
        
        // we note here that k = 1 i.e we ignore the trivial case of k = 0 as described previously
        int i = 0; 
        int j = 1;
        int k = 1;
        
        // variables to store the left and right indices of the current max lenghted palindromic subsequence
        int maxi = 0;
        int maxj = 0;
     
        while(k!=n){       
            
            // code corresponding to the algo described as above
            if(s[i] == s[j] && (k <= 2 ||  dp[i+1][j-1] == 1)){
               dp[i][j] = 1;
                 maxi = i; 
                 maxj = j;                
            }                          
            
            // this part increments the value of 'k' once we have filled up that diagonal
            // based on 'k' our indices i and j change as well
            // we can also use two for loops to acheive the same goal
            
            // note that for k = 1 , i and j are {(0,1),(1,2),(2,3)...(n-2,n-1)}
            // for k = 2, i and j are {(0,2),(1,3),(2,4)...(n-3,n-1)}
            // generalizing ---> i and j are {(0,k),(1,k+1)....(n-1-k,n-1)}
            
            // if (j == n - 1) : 
            // increment k,  reset i = 0, j = k, go back to the loop 
            
            if(j == n-1){
               // once we have filled up that diagonal, reset i to 0 and increment 'k'  
                k++;
                i = 0;
                j = k;
                continue;
            }
            
            // else simply increment i and j
            i++;
            j++;
           
        }
        
        // finally, return the required substring
        return str.substring(maxi, maxj+1);
    }
    
    
}


/*
 Method 2: O(n^2) time and constant space
 
 This method uses two pointers left and right to keep track of the ends of the substring
 Observe that in a string if we see an element consecutively, we keep incrementing right
 this represents the fact the "aba" and "abbbbbbbbba" are both palindromes
 i.e if we any # of same characters, we simply ignore them and keep incrementing right pointer
 once we reach an index such the next character is different, we stop and now start expanding the substring 
 by expanding we mean something like this :
 
                       r,l
 eg : string is ---> "  c b d d d b "                    r --> right, l --> left ; both at index 0
 
 we check if next character == curr character i.e s[r+1] == s[r]
 since it's not true, we now try to "expand" :   [ <--- (left) {repeated string} (right) ---> ]
 we assume that whatever is between left and right is the "center" of the substring
 and we have to check if the element at (right+1) is equal to element at (left-1)
 if they are equal, then they are part of "this palindromic substring" increment/decrement right and left
  Note : Make sure to check edge conditions before increment and decrementing 
 else the current palindromic substring ends here we don't increment/decrement the pointers
 we simply calculate the length and check if it's the new maximum.
 note that we don't need to do all this for each character in the string;
 we can skip the repeating characters because they were already included in the "center" previously. 
*/

class Solution {
    public String longestPalindrome(String str) {
         
        int n = str.length();
        
        // trivial case
        if(n < 2) return str; 
        
        // convert to char array for micro-optimization as in method 1
        char[] s = str.toCharArray(); 
        
        // start will store the starting index of the max length palindrome so far
        int start = 0;
        
        // maxL stores the length of the max-lengthed palindrome so far (initalized to 1 trivially)
        int maxL = 1;
        
        // left and right pointers as described in the algorithm
        int left = 0;
        int right = 0;
        
        for(int i = 0; i < n; ){
        
            // break when from the current index we can't form (or can't be the center of) a palindrome whose length will > maxL
            if (n - i <= maxL>>1) break;
            
            left = i;
            right = i;
            
            // skip the repeating characters by incrementing right pointer
            while(right < n-1 && s[right+1] == s[right]) ++right; 
            
            // 'i' should point to the first different element encountered
            i = right+1;
            
            // 'expand' and increase the size of 'this palindrome' as much as we can
            while(right < n-1 && left> 0 && s[right+1] == s[left-1]) {
                ++right;
                --left;
            }
            
            // once we finished expanding, we calculate the size of 'this palindrome' and update maxL accordingly
            int len = right-left+1;
            if(len > maxL){
                // note that 'start = i' is incorrect, since 'i' isn't the starting index of this palindrome
                // the left pointer actually keeps track of the leftmost end of this palindrome, i.e where it starts
                start = left;
                maxL = len;
            }
            
        }
        
        // return the required substring
        return str.substring(start,start+maxL);
    
    }
    
}
