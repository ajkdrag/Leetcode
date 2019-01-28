/*
  Problem at : https://leetcode.com/problems/construct-the-rectangle/
*/

class Solution {
    public int[] constructRectangle(int area) {
        int sqrt = (int) Math.sqrt(area);
        if(sqrt*sqrt == area)
            return new int[]{sqrt, sqrt};
        int i = sqrt;
        while(area%i != 0)
            --i;
        int j = area/i;
        return new int[]{j, i};
    }
}


