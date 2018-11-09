/*
  Problem at : https://leetcode.com/problems/combination-sum/
*/

class Solution {
    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return helper(candidates,0,target, candidates.length);
    }
    
    static List<List<Integer>> helper(int[] candidates, int start, int target, int len){
        List<List<Integer>> res = new ArrayList<>();
        if(target < candidates[start]) return res;
        for(int i = start; i < len; ++i){
            int val = candidates[i];
            int tar = target - val;
            if(tar == 0){
                LinkedList l = new LinkedList<Integer>();
                l.addFirst(val);
                res.add(l);
                return res;
            }
            for(List l : helper(candidates,i,tar,len)){
                ((LinkedList) l).addFirst(val);
                res.add(l);
            }
        }
        return res;
    }
}


