/*
  Problem at : https://leetcode.com/problems/univalued-binary-tree
*/

// solution one (using traversal)
class Solution {
    HashSet<Integer> storage;
    public boolean isUnivalTree(TreeNode root) {
        storage = new HashSet<Integer>();
        helper(root);
        return storage.size() == 1;
    }
    void helper(TreeNode node){
        if(node != null){
            helper(node.left);
            storage.add(node.val);
            helper(node.right);
        }
    }
}

// using recursion (concise)
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        return (root.left == null || root.left.val == root.val && isUnivalTree(root.left)) &&
               (root.right == null || root.right.val == root.val && isUnivalTree(root.right));
    }
}


