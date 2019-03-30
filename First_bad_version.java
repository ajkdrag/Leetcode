/*
  Problem at : https://leetcode.com/problems/first-bad-version/
*/

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1;
        int h = n;
        while(l < h){
            int mid = l + ((h - l)>>1);
            if(isBadVersion(mid))
                h = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}


