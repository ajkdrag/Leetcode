/*
  Problem at : 
*/

// using newton method
class Solution {
    public int mySqrt(int x) {
        long r = x;
        while (r*r > x)
            r = (r + x/r) / 2;
        return (int) r; 
    }
}

// using binary search
class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        int i= 1, j= x;
        while(i < j){
            long mid=i+(j-i)/2;
            if(mid*mid<x) i=(int)mid+1;
            else j=(int)mid;
        }
        return i*i==x ? i: i-1;
    }
}


