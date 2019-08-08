/*
  Problem at : https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Stack<Node> st;
    public TreeNode recoverFromPreorder(String S) {
        st = new Stack<Node>();
        char[] charr = S.toCharArray();
        int len = charr.length;
        TreeNode root = null;
        for(int i = 0; i < len; ){
            int depth = 0;
            char c = '0';
            while(i < len && (c = charr[i]) == '-'){
                ++depth;
                ++i;          
            }
            int num = 0;
            while(i < len && (c=charr[i]) >= '0' && c <= '9'){
                ++i;
                num = num*10 + (c-'0');
            }
            if(st.isEmpty()){
                root = new TreeNode(num);
                st.push(new Node(0, root));
                continue;
            }
            assign(num, depth);
        }
        return root;
    }
    
    void assign(int num, int depth){
        Node prev = st.peek();
        if(prev.depth < depth){
            if(prev.node.left == null){
                prev.node.left = new TreeNode(num);
                st.push(new Node(depth,prev.node.left));
            }
            else{
                prev.node.right = new TreeNode(num);
                st.push(new Node(depth,prev.node.right));
            }
        }
        else {
            while(prev.depth >= depth){
                st.pop();
                prev = st.peek();
            }
            assign(num, depth);
        }
    }
}

class Node {
    int depth;
    TreeNode node;
    Node(int depth, TreeNode node){
        this.depth = depth;
        this.node = node;
    }
}


