/*
  Problem at : https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/
  Solution at : https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/solution/
*/

class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[10000];
        for (int i : deck)
            count[i]++;
        int g = 0;
        for (int c : count)
            if (c > 0)
                if (g == 0)
                    g = c;
                else
                    g = gcd(g, c);
        return g >= 2;
    }

    public int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }
}


