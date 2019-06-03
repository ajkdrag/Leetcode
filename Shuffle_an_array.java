/*
  Problem at : https://leetcode.com/problems/shuffle-an-array/
*/

class Solution {
    private int[] array;
    private int[] original;
    private int n;

    Random rand = new Random();

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    public Solution(int[] nums) {
        array = nums;
        original = nums.clone();
        n = nums.length;
    }
    
    public int[] reset() {
        return Arrays.copyOf(original, n);
    }
    
    public int[] shuffle() {
        for (int i = 0; i < n; i++) {
            int j = randRange(i, n);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    }
}


