/*
  Problem at : https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
*/

class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        int n = num.length;
        if (n == 0) {
            return null;
        }
        TreeNode head = helper(num, 0, n - 1);
        return head;
}

    public TreeNode helper(int[] num, int low, int high) {
        if (low > high) { // Done
            return null;
        }
        int mid = (low + high)>>1;
        TreeNode node = new TreeNode(num[mid]);
        node.left = helper(num, low, mid - 1);
        node.right = helper(num, mid + 1, high);
        return node;
    }
}


