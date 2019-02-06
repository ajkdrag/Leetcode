/*
  Problem at : https://leetcode.com/problems/pascals-triangle-ii/
*/

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>(rowIndex + 1);
        res.add(1);
        while(res.size() != rowIndex + 1){
            for(int i = res.size() - 1; i >= 1; --i){
                res.set(i, res.get(i) + res.get(i - 1));
            }
            res.add(1);
        }
        return res;
    }
}


