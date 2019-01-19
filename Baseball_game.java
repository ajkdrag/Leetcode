/*
  Problem at : https://leetcode.com/problems/baseball-game/
*/

class Solution {
    public int calPoints(String[] ops) {
        int n = ops.length;
        int[] score = new int[n];
        int j = 0,sc = 0,i;
        for(i = 0; i < n;i++){
            if(ops[i].equals("C"))
                j--;
            else if(ops[i].equals("D")){
                score[j] =  2*score[j-1];
                j++;
                }
            else if(ops[i].equals("+")){
                score[j] = score[j-1] + score[j-2];
                j++;
            }
            else {
                score[j++] = Integer.parseInt(ops[i]);
              
            }
        }  
        i = 0;
        while(i < j){
            sc += score[i];  
            i++;
        }
      return sc;  
    }
}


