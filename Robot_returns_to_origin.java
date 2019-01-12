/*
  Project at : https://leetcode.com/problems/robot-return-to-origin/
*/

class Solution {
    public boolean judgeCircle(String moves) {
        int X = 0;
        int Y = 0;
        if((moves.length() & 1) == 1)
            return false;
        for(char dir : moves.toCharArray()){
            if(dir == 'L')
                X -= 1;
            else if(dir == 'R')
                X += 1;
            else if(dir == 'U')
                Y += 1;
            else if(dir == 'D')
                Y -= 1;
        }
        if(X == 0 && Y == 0)
            return true;
        return false;
    }
}


