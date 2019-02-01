/*
  Problem at : https://leetcode.com/problems/binary-tree-tilt/
*/

class Solution {
    int res = 0;
    public int findTilt(TreeNode root) {
        helper(root);
        return res;
    }
    
    public int helper(TreeNode root){
        if(root == null)
            return 0;
        int l = helper(root.left);
        int r = helper(root.right);
        res += l > r ? l - r : r - l;
        return l + root.val + r;
    }
}


