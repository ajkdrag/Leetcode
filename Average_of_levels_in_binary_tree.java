/*
  Problem at : https://leetcode.com/problems/average-of-levels-in-binary-tree/
*/

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            double sum = 0.0;
            int sz = queue.size();
            for(int i = sz; i > 0; --i) {  
                TreeNode temp = queue.poll();
                sum += temp.val;
                if(temp.left!=null)queue.offer(temp.left);
                if(temp.right!=null)queue.offer(temp.right);
            }
            result.add(sum/sz);
        }
        return result;
    }
}


