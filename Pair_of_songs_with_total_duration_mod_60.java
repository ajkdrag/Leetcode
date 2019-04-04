/*
  Problem at : https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
*/

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] arr = new int[60];
        int curr = -1;
        int len = time.length;
        for(int i = 0; i < len; ++i){
            curr = (time[i])%60;
            arr[curr]++;
        }
        int res = 0;
        int low = 1;
        int high = 59;
        int lowVal = -1;
        int highVal = -1;
        int cumSum = 0;
        len -= arr[0];
        while(low < high){
            lowVal = arr[low];
            highVal = arr[high];
            res += (lowVal*highVal);
            if((cumSum+=(lowVal + highVal)) == len)
                break;
            ++low;
            --high;
        }
        if((lowVal = arr[0]) != 0)
            res += ((lowVal)*(lowVal - 1))>>1;
        if((lowVal = arr[30]) != 0)
            res += ((lowVal)*(lowVal - 1))>>1;
        return res;
    }
}


