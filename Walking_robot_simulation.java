/*
  Problem at : https://leetcode.com/problems/walking-robot-simulation/
*/

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int x = 0, y = 0, di = 0;
        int temp = 0;
        
        Set<String> obstacleSet = new HashSet();
        for (int[] obstacle: obstacles) {
            obstacleSet.add(obstacle[0] + " " + obstacle[1]);
        }

        int ans = 0;
        for (int cmd: commands) {
            if (cmd == -2) 
                di = (di + 3) % 4;
            else if (cmd == -1)
                di = (di + 1) % 4;
            else {
                for (int k = 0; k < cmd; ++k) {
                    int newX = x + dx[di];
                    int newY = y + dy[di];
                    String position_ = newX + " " + newY;
                    if (!obstacleSet.contains(position_)) {
                        x = newX;
                        y = newY;
                        temp = x*x + y*y;
                        ans = temp > ans ? temp : ans;
                    }
                }
            }
        }

        return ans;
    }
}


