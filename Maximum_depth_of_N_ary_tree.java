/*
  Problem at : https://leetcode.com/problems/maximum-depth-of-n-ary-tree/submissions/
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        if(root == null)
            return 0;
        int max = 0;
        for(Node child : root.children){
            int child_depth = maxDepth(child);
            if(child_depth > max)
                max = child_depth;
        }
        return 1 + max;
    }
}


