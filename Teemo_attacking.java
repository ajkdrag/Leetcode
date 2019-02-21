/*
  Problem at : https://leetcode.com/problems/teemo-attacking/
*/

class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int t = duration;
        if(timeSeries.length == 0)
            return 0;
        int c = timeSeries[0] + duration - 1;
        for(int el : timeSeries){
            int newC = el+duration - 1;
            if(el > c){
                t += duration;
                c = newC;
            }
            else if (el <= c){
                t += newC - c;
                c = newC;
            }
            
        }
        return t;
    }
}

// using merge intervals logic
// see : https://leetcode.com/problems/teemo-attacking/discuss/97465/O(n)-Java-Solution-using-same-idea-of-merge-intervals

public class Solution {
    public int findPosisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0 || duration == 0) return 0;
        
        int result = 0, start = timeSeries[0], end = timeSeries[0] + duration;
        for (int i = 1; i < timeSeries.length; i++) {
            if (timeSeries[i] > end) {
                result += end - start;
                start = timeSeries[i];
            }
            end = timeSeries[i] + duration;
        }
        result += end - start;
        
        return result;
    }
}


