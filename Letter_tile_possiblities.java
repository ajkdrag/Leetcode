/*
  Problem at : https://leetcode.com/problems/letter-tile-possibilities
*/

class Solution {
    int len, res;
    char[] arr;
    public int numTilePossibilities(String tiles) {
        arr = tiles.toCharArray();
        len = arr.length;
        res = 0;
        Arrays.sort(arr);
        dfs(0);
        return res-1;
    }
    
    void dfs(int start){
        ++res;
        for(int i = start; i < len; ++i){
            if(i-1 >= start && arr[i] == arr[i-1])
                continue;
            swap(i, start);
            dfs(start+1);
            unswap(i, start);
        }
    }
    
    void swap(int i, int j){
        char t = arr[i];
        for(int k = i; k > j; --k)
            arr[k] = arr[k-1];
        arr[j] = t;
    }
    
    void unswap(int i, int j){
        char t = arr[j];
        for(int k = j; k < i; ++k)
            arr[k] = arr[k+1];
        arr[i] = t;
    }
}


