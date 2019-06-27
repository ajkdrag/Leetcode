/*
  Problem at : https://leetcode.com/problems/find-largest-value-in-each-tree-row/
*/

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        int sz = 1;
        int max = root.val;
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            max = max > curr.val ? max : curr.val;
            --sz;
            if(curr.left != null){
                q.offer(curr.left);
            }
            
            if(curr.right != null){
                q.offer(curr.right);
            }
            if(sz == 0){
                res.add(max);
                sz = q.size();
                max = Integer.MIN_VALUE;
            }
        }
        return res;
    }
}


