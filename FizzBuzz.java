/*
  Problem at : https://leetcode.com/problems/fizz-buzz/
*/

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<String>();
        String temp = "";
        for(int i = 1; i <= n; ++i){
            temp = "";
            if(i%3 == 0)
                temp += "Fizz";
            if(i%5 == 0)
                temp += "Buzz";
            if(temp.equals(""))
                temp = String.valueOf(i);
            res.add(temp);
        }
        return res;
    }
}


