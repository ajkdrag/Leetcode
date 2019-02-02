/*
  Problem at : https://leetcode.com/problems/student-attendance-record-i/
*/

class Solution {
    public boolean checkRecord(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        boolean found = arr[0] == 'A';
        boolean cont = false;
        for(int i = 1; i < len; ++i){
            char curr = arr[i];
            if(curr == 'A'){
                if(found)
                    return false;
                found = true;
            }
            if(curr == 'L'){
                if(cont)
                    return false;
                if(curr == arr[i - 1])
                    cont = true;
            }
            else
                cont = false;
        }
        return true;        
    }
}


