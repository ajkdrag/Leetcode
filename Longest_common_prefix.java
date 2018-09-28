/*
  Problem at : https://leetcode.com/problems/longest-common-prefix/
  Solution article at : https://leetcode.com/articles/longest-common-prefix/
  
  Algo : Find the string with the min length. The longest common prefix cannot be more that this min length.
         For each string, if the character at current index doesn't match the character at the same index of the previous string
         We break out of our loop and the length of the longest common prefix will be upto that index for which characters 
         matched in all strings.
         eg: Str = {"Hello", "Hey", "He"}
             min-length = 2
             j = 0 
             we see that till j = 1, all characters matched and at j = 2, we broke out of the loop
             and the longest common prefix will the substring s[0,j] where 's' can be any one of the strings
             
         Note that here we are matching the current string character with the previous string character. 
         Instead of that, we can try matching with any one of the strings from the array, because for the string
         to be a common prefix, it must be common to all anyway.
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
		int j = -1;
		int min_length = Integer.MAX_VALUE;
		for(String s : strs){
            int len = s.length();
            if(len == 0) return "";
			if(len < min_length) min_length = s.length();
		}      
		boolean done = true;
		while (done) {
			++j;
			for (int i = 1; i < strs.length; ++i) {
				if (j == min_length || strs[i].charAt(j) != strs[i - 1].charAt(j)) {
					done = false;
					break;
				}
			}

		}
		return strs[0].substring(0, j);
	}
}

