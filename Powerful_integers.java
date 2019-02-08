/*
  Problem at : https://leetcode.com/problems/powerful-integers/
*/

class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 1 ; ; i*=x){
            if(i >= bound)
                break;
            for(int j = 1; ; j*=y){
                int sum = i + j;
                if(sum > bound)
                    break;
                if(!set.contains(sum))
                    set.add(sum);
                if(y == 1)
                    break;
            }
            if(x == 1)
                return new ArrayList<>(set);
        }
        return new ArrayList<>(set);
    }
}


