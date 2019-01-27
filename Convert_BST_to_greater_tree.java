/*
  Problem at : https://leetcode.com/problems/convert-bst-to-greater-tree/
*/

class Solution {
    public TreeNode convertBST(TreeNode root) {
        helper(root, 0);
        return root;
    }
    
    int helper(TreeNode root, int val){
        if(root == null)
            return val;
        int g = helper(root.right, val);
        int temp = root.val + g;
        root.val = temp;
        return helper(root.left, temp);
    }
}

// iterative soln
class Solution {
    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (!stack.isEmpty() || node != null) {
            /* push all nodes up to (and including) this subtree's maximum on
             * the stack. */
            while (node != null) {
                stack.add(node);
                node = node.right;
            }

            node = stack.pop();
            sum += node.val;
            node.val = sum;

            /* all nodes with values between the current and its parent lie in
             * the left subtree. */
            node = node.left;
        }

        return root;
    }
}


