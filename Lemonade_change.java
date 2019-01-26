/*
  Problem at : https://leetcode.com/problems/lemonade-change/
*/

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] balance = new int[3];
        for(int i : bills){
            if(i == 5)
                balance[0]++;
            if(i == 10){
                if(balance[0] == 0)
                    return false;
                balance[0]--;
                balance[1]++;
            }
            if(i == 20){
                int bal5 = balance[0];
                int bal10 = balance[1];
                if(bal5 >= 1 && bal10 >= 1){
                    balance[0]--;
                    balance[1]--;
                    balance[2]++;
                    continue;
                }
                else if(bal5 >= 3){
                    balance[0]-=3;
                    balance[2]++;
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}


