/*
  Problem at : https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
*/

// bfs sol
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        LinkedList<List<Integer>> res = new LinkedList<>();
        if(root == null)
            return res;
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> temp = new LinkedList<>();
            for(int i = 0, lim = q.size(); i < lim; ++i){
                TreeNode curr = q.poll();
                temp.add(curr.val);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            res.addFirst(temp);
        }
        return res;
    }
}

// dfs solution 
class Solution {
  public class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
            levelMaker(wrapList, root, 0);
            return wrapList;
        }
        
        public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
            if(root == null) return;
            if(level >= list.size()) {
                list.add(0, new LinkedList<Integer>());
            }
            levelMaker(list, root.left, level+1);
            levelMaker(list, root.right, level+1);
            list.get(list.size()-level-1).add(root.val);
        }
    }
}



