/*
  Problem at : https://leetcode.com/problems/longest-univalue-path/
*/

class Solution {
    int max = 0;
    public int longestUnivaluePath(TreeNode root){
        helper(root);
        return max;
    }
    
    public int helper(TreeNode root) {
        if(root == null)
            return 0;
        int l = helper(root.left);
        int r = helper(root.right);
        if(root.left != null && root.val == root.left.val)
            l++;
        else
            l = 0;
        if(root.right != null && root.val == root.right.val)
            r++;
        else
            r = 0;
        max = l + r > max ? l + r : max;
        return l > r ? l : r;
    }
}


