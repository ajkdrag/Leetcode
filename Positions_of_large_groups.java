/*
  Problem at : https://leetcode.com/problems/positions-of-large-groups/
*/

class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        int start = 0;
        S += " ";
        char[] arr = S.toCharArray();
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> temp;
        for(int i = 1, len = arr.length; i < len; ++i){
            if(arr[i] != arr[i - 1]){
                int diff = i - start;
                if(diff >= 3){
                    temp = new LinkedList<>();
                    temp.add(start);
                    temp.add(i - 1);
                    res.add(temp);
                }
                start = i;
            }
        }
        return res;
    }
}


