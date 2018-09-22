/*
  Roman literals start at 'C' and end at 'X' <-- that's a range of 22 alphabets.
  We make an array (or we could have used a HashMap as well) that store corresponding values of alphabets to their values
  map[0] = 100 implies that C = 100
  map[1] = 500 implies that D = 500
  so on...
  Note that ASCII value of C is not '0' so in order to index a Roman alphabet to it's corresponding value
  we do (Roman_alph - 'C') <-- this makes the offset as 0, such that proper indexing into this above array could be done.
  
  Rest is simple, we iterate the string right to left and convert each alphabet to it's value according to the map.
  Note that there are a few odd cases which we need to consider : 
    If I comes before V or X, subtract 1 eg: IV = 4 and IX = 9
    If X comes before L or C, subtract 10 eg: XL = 40 and XC = 90
    If C comes before D or M, subtract 100 eg: CD = 400 and CM = 900
*/

class Solution {
    public int romanToInt(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        // Array to map Roman alphabets to their corresponding numerical values (hashmap can be used as well)
        int[] map = new int[22];
        map[0] = 100;
        map[1] = 500;
        map[6] = 1;
        map[9] = 50;
        map[10] = 1000;
        map[19] = 5;
        map[21] = 10;
        // make sure to subtract 'C', since 'C' represents index 0 of our map, 'D' represents index 1 and so on...
        int res = map[arr[n-1] - 'C'];
        for(int i = n - 2; i >= 0; --i){
            // take care of the odd cases if they exist
            if(arr[i] == 'I' && (arr[i + 1] == 'X' || arr[i + 1] == 'V')) res -= 1;
            else if(arr[i] == 'X' && (arr[i + 1] == 'L' || arr[i + 1] == 'C')) res -= 10;
            else if(arr[i] == 'C' && (arr[i + 1] == 'D' || arr[i + 1] == 'M')) res -= 100;
            // else simply map the alphabets to their corresponding numeric values and add to our result 
            else res += map[arr[i] - 'C'];
        }
        return res;
    }
}

