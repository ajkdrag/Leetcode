/*
  Problem at : https://leetcode.com/problems/range-sum-of-bst/
*/

// basic recursive
class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null)
            return 0;
        int l = rangeSumBST(root.left, L, R);
        int r = rangeSumBST(root.right, L, R);
        if(root.val >= L && root.val <=R)
            return l + r + root.val;
        return l + r;
    }
}

// dfs
class Solution {
    int ans;
    public int rangeSumBST(TreeNode root, int L, int R) {
        ans = 0;
        dfs(root, L, R);
        return ans;
    }
    public void dfs(TreeNode node, int L, int R) {
        if (node != null) {
            if (L <= node.val && node.val <= R)
                ans += node.val;
            if (L < node.val)
                dfs(node.left, L, R);
            if (node.val < R)
                dfs(node.right, L, R);
        }
    }
}


