/*
  Problem at : https://leetcode.com/problems/increasing-order-search-tree/
*/

class Solution {
    public TreeNode increasingBST(TreeNode root) {
        if(root == null)
            return root;
        TreeNode leftPart = increasingBST(root.left);
        root.right = increasingBST(root.right);
        if(leftPart == null)
            return root;
        TreeNode rightMost = leftPart;
        while(rightMost.right != null)
            rightMost = rightMost.right;
        rightMost.right = root;
        root.left = null;
        return leftPart;
    }
}

// Another better solution where instead of looping to find the predecessor, we keep another pointer.
class Solution {
    TreeNode cur;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        cur = ans;
        inorder(root);
        return ans.right;
    }

    public void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        node.left = null;
        cur.right = node;
        cur = node;
        inorder(node.right);
    }
}


