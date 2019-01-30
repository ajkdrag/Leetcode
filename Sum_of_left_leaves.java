/*
  Problem at : https://leetcode.com/problems/sum-of-left-leaves/
*/

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, false);
    }
    
    int helper(TreeNode root, boolean left){
        if(root == null)
            return 0;
        if(root.left == null && root.right == null && left)
            return root.val;
        int l = helper(root.left, true);
        int r = helper(root.right, false);
        return l + r;
    }
}


