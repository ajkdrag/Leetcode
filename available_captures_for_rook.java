/*
  Problem at : https://leetcode.com/problems/available-captures-for-rook/
*/

class Solution {
    public int numRookCaptures(char[][] board) {
        int numberOfSteps = 0;
        for(int i=0;i < 8 ;i++){
            for(int j=0;j < 8 ;j++){
                if(board[i][j]=='R'){
                    numberOfSteps+=goUp(board,i,j)? 1:0;
                    numberOfSteps+=godown(board,i,j)? 1:0;
                    numberOfSteps+=goLeft(board,i,j)? 1:0;
                    numberOfSteps+=goRight(board,i,j) ?1:0;
                    break;
                }
            }
        }
        return numberOfSteps;
    }

    private boolean goUp(char[][]board, int i,int j){
        for(;i>=0;i--){
            if(board[i][j]=='B'){
                return false;
            }
            if(board[i][j]=='p'){
                return true;
            }
        }
        return false;
    }

    private boolean godown(char[][]board, int i,int j){
        for(;i < 8; i++){
            if(board[i][j]=='B'){
                return false;
            }
            if(board[i][j]=='p'){
                return true;
            }
        }
        return false;
    }

    private boolean goLeft(char[][]board, int i,int j){
        for(;j>=0;j--){
            if(board[i][j]=='B'){
                return false;
            }
            if(board[i][j]=='p'){
                return true;
            }
        }
        return false;
    }

    private boolean goRight(char[][]board, int i,int j){
        for(;j< 8;j++){
            if(board[i][j]=='B'){
                return false;
            }
            if(board[i][j]=='p'){
                return true;
            }
        }
        return false;
    }
}


