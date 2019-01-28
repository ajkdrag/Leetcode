/*
  Problem at : https://leetcode.com/problems/maximum-product-of-three-numbers/
*/

class Solution {
    public int maximumProduct(int[] nums) {
        int max1 = -2000;
        int max2 = max1;
        int max3 = max1;
        int min1 = 2000;
        int min2 = min1;
        for(int i : nums){
            if(i > max1){
                max3 = max2;
                max2 = max1;
                max1 = i;
            }
            else if (i > max2){
                max3 = max2;
                max2 = i;
            }
            else if(i > max3){
                max3 = i;
            }     
            
            if(i < min1){
                min2 = min1;
                min1 = i;
            }
            else if(i < min2){
                min2 = i;
            }
        }
        int max_prod = max1*max2*max3;
        int min_prod = min1*min2*max1;
        return max_prod > min_prod ? max_prod : min_prod;
    }
}


