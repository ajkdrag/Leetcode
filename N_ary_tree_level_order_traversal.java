/*
  Problem at : https://leetcode.com/problems/n-ary-tree-level-order-traversal/
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            List<Integer> step = new ArrayList<>();
            for(int sz = queue.size(); sz > 0; sz--) {  
                Node temp = queue.poll();
                step.add(temp.val);
                for(Node child : temp.children) {
                    queue.offer(child);
                }
            }
            result.add(step);
        }
        return result;
    }
}


