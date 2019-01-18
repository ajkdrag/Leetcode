/*
  Problem at : https://leetcode.com/problems/leaf-similar-trees/
*/

class Solution {
    Deque<Integer> qu = new ArrayDeque<>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        dfs(root1);
        return check(root2) && qu.isEmpty();
    }
    
    private void dfs(TreeNode cur) {
        if(cur.left == null && cur.right == null) {
            qu.offer(cur.val);
            return;
        }
        if(cur.left != null) {
            dfs(cur.left);
        }
        if(cur.right != null) {
            dfs(cur.right);
        }
    }
    
    private boolean check(TreeNode cur) {
        if(cur.left == null && cur.right == null) {
            return qu.poll() == cur.val;
        }
        boolean result = true;
        if(cur.left != null) {
            result = check(cur.left);
        }
        if(result && cur.right != null) {
            result = check(cur.right);
        }
        return result;
    }
}


