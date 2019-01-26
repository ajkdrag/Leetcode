/*
  Problem at : https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
  Solution at : https://leetcode.com/problems/two-sum-iv-input-is-a-bst/solution/
*/

class Solution {
    ArrayList<Integer> vals;
    public boolean findTarget(TreeNode root, int k) {
        vals = new ArrayList<>();
        fillArr(root);
        int i = 0;
        int j = vals.size() - 1;
        while(i < j){
            int left = vals.get(i);
            int right = vals.get(j);
            if(left + right == k)
                return true;
            else if(left + right < k)
                ++i;
            else 
                --j;
        }
        return false;
    }
    
    void fillArr(TreeNode root){
        if(root != null){
            fillArr(root.left);
            vals.add(root.val);
            fillArr(root.right);
        }
    }
}

// using Hashset
class Solution {
    HashSet<Integer> vals;
    boolean res;
    int target;
    public boolean findTarget(TreeNode root, int k) {
        target = k;
        vals = new HashSet<>();
        fillArr(root);
        return res;
    }
    
    void fillArr(TreeNode root){
        if(root != null && !res){
            fillArr(root.left);
            int curr = root.val;
            if(vals.contains(target - curr)){
                res = true;
                return;
            }
            vals.add(curr);
            fillArr(root.right);
        }
    }
}


