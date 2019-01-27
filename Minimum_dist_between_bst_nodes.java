/*
  Problem at : https://leetcode.com/problems/minimum-distance-between-bst-nodes/
  Works for this problem as well : https://leetcode.com/problems/minimum-absolute-difference-in-bst/
*/

class Solution {
    int min = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        helper(root);
        return min;
    }
    
    public int[] helper(TreeNode root){
        int[] l = new int[2];
        int[] r = new int[2];
        int curr = root.val;
        if(root.left == null && root.right == null){
            return new int[]{root.val, root.val};
        }
        else if(root.left == null){
            r = helper(root.right);
            if(r[0] - curr < min)
                min = r[0] - curr;
            return new int[]{curr, r[1]};
        }
        else if(root.right == null){
            l = helper(root.left);
            if(curr - l[1] < min)
                min = curr - l[1];
            return new int[]{l[0], curr};
        }
        else{
            l = helper(root.left);
            r = helper(root.right);
            if(curr - l[1] < min)
                min = curr - l[1];
            if(r[0] - curr < min)
                min = r[0] - curr;
            return new int[]{l[0], r[1]};
        }
    }
}

// a better solution (in terms of execution time, time complexity wise both are same)
class Solution {
    Integer res = Integer.MAX_VALUE, pre = null;
    public int minDiffInBST(TreeNode root) {
        if (root.left != null) minDiffInBST(root.left);
        if (pre != null) res = Math.min(res, root.val - pre);
        pre = root.val;
        if (root.right != null) minDiffInBST(root.right);
        return res;
    }
}


