/*
  Problem at : https://leetcode.com/problems/can-place-flowers
*/

// greedy approach
public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0, count = 0;
        int len = flowerbed.length;
        int curr = 0;
        int left = 0;
        int right = 0;
        if(n == 0)
            return true;
        while (i < len) {
            curr = flowerbed[i];
            left = i > 0 ? flowerbed[i - 1] : 0;
            right = i < len - 1 ? flowerbed[i + 1] : 0;
            if (curr + left + right == 0) {
                flowerbed[i] = 1;
                ++count;
                if(count == n)
                    return true;
            }
            i++;
        }
        return false;
    }
}


