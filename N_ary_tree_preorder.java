/*
  Problem at : https://leetcode.com/problems/n-ary-tree-preorder-traversal/
  Solution : https://leetcode.com/problems/n-ary-tree-preorder-traversal/solution/
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

// DFS is similar to preorder, and since the problem statement asked for iterative version, we use stack to accomplish this.
class Solution {
    public List<Integer> preorder(Node root) {
        Stack<Node> st = new Stack<Node>();
        List<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        st.push(root);
        while(!st.isEmpty()){
            Node curr = st.pop();
            res.add(curr.val);
            for(int i = curr.children.size() - 1; i >= 0; --i)
                st.push(curr.children.get(i));
        }
        return res;
    }
}


