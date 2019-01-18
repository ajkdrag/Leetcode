/*
  Problem at : https://leetcode.com/problems/keyboard-row/
*/

class Solution {
    public String[] findWords(String[] words) {
        int[] row = {1, 2, 2, 1, 0, 1, 1, 1, 0, 1, 1, 1, 2, 2, 0, 0, 0, 0, 1, 0, 0, 2, 0, 2, 0, 2};
        ArrayList<String> res = new ArrayList<String>();
        for(String s : words){
            boolean isValid = true;
            int len = s.length();
            char[] arr = s.toCharArray();
            for(int i = 1; isValid && i < len; ++i){
                char prev = arr[i - 1];
                char curr = arr[i];
                if(prev >= 'A' && prev <= 'Z')
                    prev = (char) (prev - 'A');
                else
                    prev = (char) (prev - 'a');
                
                if(curr >= 'A' && curr <= 'Z')
                    curr = (char) (curr - 'A');
                else
                    curr = (char) (curr - 'a');
                
                if(row[prev] != row[curr])
                    isValid = false;
            }
            if(isValid)
                res.add(s);
        }
        return res.toArray(new String[res.size()]);
    }
}


