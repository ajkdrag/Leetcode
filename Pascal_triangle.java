/*
  Problem at : https://leetcode.com/problems/pascals-triangle/
*/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>(numRows);
        if(numRows == 0)
            return res;
        res.add(new ArrayList<Integer>(){{
            add(1);
        }});
        for(int i = 1; i < numRows; ++i){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(1);
            while(res.get(i - 1).size() != temp.size())
                temp.add(res.get(i-1).get(temp.size() - 1) + res.get(i-1).get(temp.size()));
            temp.add(1);
            res.add(temp);
        }
        return res;
    }
}


