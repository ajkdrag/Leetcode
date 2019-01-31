/*
  Problem at : https://leetcode.com/problems/longest-palindrome/
*/

class Solution {
    public int longestPalindrome(String s) {
        int table[] = new int[128];
        int size = s.length();
        int sum = 0;
        int odd = 0;
        for (char c : s.toCharArray())
        {
            table[c]++;
        }

        for (int i = 0; i < 128; i++)
        {
            int val = table[i];
            sum += val;
            if((val&1) == 1)
            {
                sum -= 1;
                odd = 1;
            }
        }
        return sum+odd;
    }
}

// another approach 
class Solution {
    public int longestPalindrome(String s) {
        int len = s.length();
        if (s == null || len < 1) return 0;
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) set.remove(c);
            else set.add(c);
        }
        if (set.size() <= 1) return len;
        return len - set.size() + 1;
    }
}


