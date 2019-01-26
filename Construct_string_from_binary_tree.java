/*
  Problem at : https://leetcode.com/problems/construct-string-from-binary-tree/
*/

class Solution {
    public String tree2str(TreeNode t){
        StringBuilder res = new StringBuilder();
        helper(t, res);
        int n = res.length();
        if(n == 0)
            return res.toString();
        return res.substring(1, res.length() - 1);
    }
    public void helper(TreeNode t, StringBuilder sb){
        if(t == null)
            return;
        sb.append("(").append(t.val);
        if (t.left == null && t.right == null){
            sb.append(")");
            return;
        }
        if (t.left == null){
            sb.append("()");
        }
        else 
            helper(t.left, sb);
        helper(t.right, sb);
        sb.append(")");
    }
}


