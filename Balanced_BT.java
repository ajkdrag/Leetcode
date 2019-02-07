/*
  Problem at : https://leetcode.com/problems/balanced-binary-tree/
*/

class Solution {
    boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        helper(root);
        return balanced;
    }
    
    int helper(TreeNode root){
        if(balanced){
            if(root == null)
            return 0;
            int l = helper(root.left);
            int r = helper(root.right);
            if(Math.abs(l - r) > 1)
                balanced = false;
            return 1 + (l > r ? l : r);
        }
        return -1;
    }
}


