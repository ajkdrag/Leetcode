/*
  Problem at : https://leetcode.com/problems/array-partition-i
  Range of values is -10000 < val < 10000, hence we have used a counting sort kind of approach for solution 2.
*/

// Solution 1 (O(log n))
 class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for(int i = nums.length - 2; i >= 0; i -= 2)
            res += nums[i];
        return res;
    }
}

// Solution 2 (O(n))
public class Solution {
	public int arrayPairSum(int[] nums) {
		int[] exist = new int[20001];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
			exist[num + 10000]++;
            if(num > max){
                max = num;
            }
            if(num < min){
                min = num;
            }
		}
		int sum = 0;
		boolean odd = true;
		for (int i = min + 10000; i <= max+10000; i++) {
			while (exist[i] > 0) {
				if (odd) {
					sum += i - 10000;
				}
				odd = !odd;
				exist[i]--;
			}
		}
		return sum;
	}
}


