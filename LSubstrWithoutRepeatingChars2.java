class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        // trivial case check
        if (s == null || s.length() == 0) return 0;
        
        // the lookup array stores for each character the most recent occurence of it seen so far
        // initialize the entries with -1 or any other negative value to indicate that we haven't seen any of them so far
        int[] lookup = new int[128];
        for(int i = 0; i < 128; i++){
            lookup[i] = -1;
        }
        int length = s.length();
        int max = 0;
        for (int left = 0, right = 0; right < length; right++) {
            char c = s.charAt(right);
            
            // left is the index of the starting substring
            // left is either the left from the previous iteration or the next index from the previous occurence of this character
            left = Math.max(left, lookup[c] + 1);
            max = Math.max(max, right - left + 1); 
            
            // lookup[c] is the latest occurence of this character which is this current index(right) itself
            lookup[c] = right; 
        }
        return max;
    }
}
