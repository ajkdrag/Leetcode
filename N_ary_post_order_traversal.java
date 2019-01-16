/*
  Problem at : https://leetcode.com/problems/n-ary-tree-postorder-traversal/
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

// Basically it's reverse of reverse Postorder.
// Reverse Postorder is a simple modification of the preorder traversal, only we push children in reverse order.
class Solution {
    public List<Integer> postorder(Node root) {
        Stack<Node> st1 = new Stack<Node>();
        LinkedList<Integer> res = new LinkedList<Integer>();
        if(root == null)
            return res;
        st1.push(root);
        while(!st1.isEmpty()){
            Node curr = st1.pop();
            res.addFirst(curr.val);
            for(Node child : curr.children){
                st1.push(child);
            }
        }
        return res;
    }
}


