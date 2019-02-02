/*
  Problem at : https://leetcode.com/problems/happy-number/
*/

// using Floyd-cycle approach
class Solution {
    public boolean isHappy(int n) {
        if(n == 1) return true;
        int n1 = n;
        while(true){
            n = help(help(n));
            n1 = help(n1);
            if(n1 == 1 || n == 1) return true;
            if(n1 == n && n != 1) return false;
        }
    }
    private int help(int n){
        int temp = 0;
        while(n != 0){
            int tail = n % 10;
            temp += tail * tail;
            n /= 10;
        }
        return temp;
    }
}

// recursive bootlegged approach
class Solution {
    public boolean isHappy(int n) {
	if(n<10) {
		if(n==1||n==7) return true;
		else return false;
	 }
	int b;int sum=0;
	while(n>0) {
		  b=n%10;
		  sum=sum+b*b; 
		  n=n/10;
	  } 
     return isHappy(sum);
  }
}


