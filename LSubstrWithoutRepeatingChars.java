// LeetCode 3 : Longest Substring without repeating characters
// eg "OBAMACARE" output should be 4
// eg "ABBA" output should be 2

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        // trivial case check
        int sLen = s.length();
        if(sLen < 2) return sLen;
        
        // convert string to charArray for ease
        char[] cArr = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<Character,Integer>();
        char current_char = '\0';
        int start = 0;
        int max_len = 0;
        
        // for each character check if within the current substring
        // we have found a previous occurence of the character or not
        // if yes, end this substring and start off the new substring from that index + 1
        // eg : ABBA , When 'i' is at index 2; since we have a previous occurence of B, we end that substring
        // next substring starts from map.get('B') + 1 , which is 1 + 1 = 2 
        
        for(int i = 0; i < sLen ; i++){
            current_char = cArr[i];
            
            // the check "map.get(char) >= start" ensures that we only consider previous occurences of a character
            // that are within the current substring only
            if(map.containsKey(current_char) && map.get(current_char) >= start){
                start = map.get(current_char) + 1;
            }
            
            // update max_len and the index of the character in the map accordingly
            // making sure to point to latest occurence of the character
            max_len = Math.max(max_len, i - start + 1);
            map.put(current_char,i);
        }
        
        return max_len;
    }
}
