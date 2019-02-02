/*
  Problem at : 
*/

// DFS
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<String>();
        if (root != null) searchBT(root, "", answer);
        return answer;
    }
    private void searchBT(TreeNode root, String path, List<String> answer) {
        if (root.left == null && root.right == null) answer.add(path + root.val);
        if (root.left != null) searchBT(root.left, path + root.val + "->", answer);
        if (root.right != null) searchBT(root.right, path + root.val + "->", answer);
    }
}

// Recursion
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> sList=new LinkedList<String>();
        if (root==null) return sList;
        if (root.left==null && root.right==null) {
            sList.add(Integer.toString(root.val));
            return sList;
        }

        for (String s: binaryTreePaths(root.left)) {
            sList.add(Integer.toString(root.val)+"->"+s);
        }
        for (String s: binaryTreePaths(root.right)) {
            sList.add(Integer.toString(root.val)+"->"+s);
        }
        return sList;
    }
}


