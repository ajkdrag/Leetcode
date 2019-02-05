/*
  Problem at : https://leetcode.com/problems/plus-one/
*/

class Solution {
    public int[] plusOne(int[] digits) {
        int[] res = new int[digits.length + 1];
        int sum = 0;
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; --i){
            sum = carry + digits[i];
            carry = 0;            
            if(sum == 10){
                sum = 0;
                carry = 1;
            }
            res[i + 1] = sum;
        }
        res[0] = carry;
        return carry == 0 ? Arrays.copyOfRange(res, 1, res.length) : res;
    }
}


