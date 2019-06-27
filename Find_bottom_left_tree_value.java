/*
  Problem at : https://leetcode.com/problems/find-bottom-left-tree-value/
*/

// bfs based solution
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int sz = 1;
        boolean search = true;
        int res= root.val;
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            --sz;
            
            if(curr.left != null){
                q.add(curr.left);
                if(search){
                    res = curr.left.val;
                    search = false;
                }
            }
            if(curr.right != null){
                q.add(curr.right);
                if(search){
                    res = curr.right.val;
                    search = false;
                }   
            }
            
            if(sz == 0){
                sz = q.size();
                search = true;
            }
        }
        
        return res;
    }
}


