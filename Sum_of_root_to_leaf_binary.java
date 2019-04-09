/*
  Problem at : https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
*/

class Solution {
    public int sumRootToLeaf(TreeNode root) {
		int nodesum = 0;
		return preOrder(root, nodesum);
	}

	public int preOrder(TreeNode root, int nodesum) {
		if (root == null) {
			return 0;
		}
		nodesum = (nodesum<<1)+ root.val;
		if (root.left == null && root.right == null) {
			return nodesum;
		}
		return preOrder(root.left, nodesum) + preOrder(root.right, nodesum);
	}
}


