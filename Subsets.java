/*
  Problem at : https://leetcode.com/problems/subsets/description/
  Method 1 : Using backtracking --> At each state, we have a choice to either "choose" the current element or "not choose" it
             for the current subset. The base condition is when we have scanned through the entire array, and made our choices
             in which case, we simply store our choices in the result, and backtrack to the next set of choices... and so on.
*/

class Solution {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> chosen = new ArrayList<>();
        helper(nums,result,0,chosen);
        return result;
    }
    
    public static void helper(int[] nums, List<List<Integer>> res, int start, List<Integer> chosen){
        if(start >= nums.length) {
            res.add(new ArrayList<>(chosen));
            return;
        }
        helper(nums,res,start+1,chosen);
        int choice = nums[start];
        chosen.add(choice);
        helper(nums,res,start+1,chosen);
        chosen.remove(chosen.size() - 1);
    }
}

/*
  Method 2 : Using bit manipulation --> 000 --> 111 when iterated, yields all the possible subsets where 000 implies "not choosing"
             any of the elements, 001 implies choosing the last element and so on... Since we have two options for any state (to choose
             or not to choose), this binary approach works perfectly.
*/

class Solution {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> chosen;
        int len = nums.length;
        for(int i = (1<<len) - 1; i >= 0; --i){
            chosen = new ArrayList<Integer>();
            int k = 1;
            int c = 0;
            while(k <= i){
                if((i&k) != 0) chosen.add(nums[c]);
                k<<=1;
                ++c;
            }
            result.add(chosen);
        }
        return result;
    }
}


