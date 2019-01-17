/*
  Problem at : 
*/

class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        int total_len = 0;
        int line_num = 0;
        int[] line = new int[100];
        int[] res = new int[2];
        for(char c : S.toCharArray()){
            int curr_width = widths[c - 'a'];
            total_len += curr_width;
            if(total_len > 100){
                line[line_num++] = total_len - curr_width;
                total_len = curr_width;
            }
        }
        res[0] = line_num + 1;
        res[1] = total_len;
        return res;
    }
}


