/*
  Problem at : https://leetcode.com/problems/4sum/
  Extension of the 3Sum problem with duplicate checks.
*/

class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> result = new LinkedList<>(); 
        
        for(int k = 0; k < num.length - 3; k++){
           if(k == 0 || num[k] != num[k - 1]){
                int tar = target - num[k];
                for (int i = k + 1; i < num.length-2; i++) {
                    if (i == k + 1 || num[i] != num[i-1]) {
                        int lo = i+1, hi = num.length-1, sum = tar-num[i];
                        while (lo < hi) {
                            if (num[lo] + num[hi] == sum) {
                                result.add(Arrays.asList(num[k],num[i], num[lo], num[hi]));
                                while (lo < hi && num[lo] == num[lo+1]) lo++;
                                while (lo < hi && num[hi] == num[hi-1]) hi--;
                                lo++; hi--;
                            } 
                            else if (num[lo] + num[hi] < sum) lo++;
                            else hi--;
                       }
                    }
                }
            }
        }
        return result;
    }
}


