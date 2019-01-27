/*
  Problem at : https://leetcode.com/problems/1-bit-and-2-bit-characters/
  Solution at : https://leetcode.com/problems/1-bit-and-2-bit-characters/solution/
*/

class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int len = bits.length;
        if(len == 1)
            return true;
        return isValid(bits, len - 2);
    }
    
    public boolean isValid(int[] bits, int id){
        int i = bits[id];
        if(id == 0)
            return i == 0;
        int j = bits[id - 1];
        if(id == 1)
            return j != 0 || i != 1;
        if(i == 0){
            if(j == 0)
                return isValid(bits, id - 1);
            else
                return isValid(bits, id - 1) || isValid(bits, id - 2);
        }
        if(j == 1)
            return isValid(bits, id - 2);
        return false;
    }
}

// better solution
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            i += bits[i] + 1;
        }
        return i == bits.length - 1;
    }
}

