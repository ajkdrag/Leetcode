/*
  Problem at : https://leetcode.com/problems/3sum/
  Algo : O(N*N) Sort the array and for each element 'i' find the 2Sum of (0 - arr[i]) i.e (-arr[i]) (use 2 pointer for 2Sum solution)
*/

class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> result = new LinkedList<>(); 
        for (int i = 0; i < num.length-2; i++) {
            // num[i] != num[i-1] check skips the duplicates
            if (i == 0 || num[i] != num[i-1]) {
                // 2Sum solution (using 2 pointers) with target = -num[i] and start index = (i + 1) and end index = (array length - 1)
                int lo = i+1, hi = num.length-1, sum = -num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        result.add(Arrays.asList(num[i], num[lo], num[hi]));
                        // while loops to skip through duplicates
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
               }
            }
        }
        return result;
    }
}

