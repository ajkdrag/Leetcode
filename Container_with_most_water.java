/*
  We have to maximize the Area that can be formed between the vertical lines using the shorter line as length and 
  the distance between the lines as the width of the rectangle forming the area.
  
  Algo : We use the two-pointer approach to solve this problem.
  Basically, the height of the water column is limited by the smaller of two vertical lines while the length is distance between them.
  So, consider these scenarios :
    Suppose our left line is shorter than the right line and we are the extreme ends
    -->   left1_ _ _ _ _ right1
   
    ==>   Area1 = left1_height * dist(right1-left1)
    
    if we shift the right pointer towards the left i.e
    -->   left1_ _ _ _ right2 _
   
    and now we consider both cases when left1 > right2 and left1 < right2.
    Say, left1 > right2;
    
    ==>   Area2 = right2_height * (right2 - left1)
    
    Clearly, right2_height < left1_height and (right2 - left1) < (right1 - left1) ==> Area2 < Area1
    Now consider, left1 < right2; 
    
    ==>   Area3 = left1_height * (right2 - left1),    
    
    yet again ==> Area3 < Area1, it's clear that shifting the pointer from the higher vertical line is not an optimal approach
    Therefore we must shift the pointer from the lower vertical line and recompute the area and so on.
*/

class Solution {
    public int maxArea(int[] height) {
        // trivial case
        int n = height.length;
        if(n == 0) return 0;
        // the two pointers
        int left = 0;
        int right = n -1;
        // maxCap stores global max capacity
        // tempCap stores current water capacity
        int maxCap = 0;
        int tempCap = 0;
        while(left < right){
            int l = right - left;
            // water height is limited by the smaller vertical line
            int h = Math.min(height[left],height[right]);
            tempCap = h * l;
            if(tempCap > maxCap) maxCap = tempCap;
            // move pointer from the smaller side (only one of these 2 while loops will run if vertical lines are of unequal height)
            // in case both lines are of equal height, then move both pointers until we hit a higher vertical line
            // basically we aim to hit a higher vertical line by moving the pointer(s) from smaller vertical lines
            while(left < right && height[left] <= h) ++left;
            while(left < right && height[right] <= h) --right;
        }
        return maxCap;
    }
}

