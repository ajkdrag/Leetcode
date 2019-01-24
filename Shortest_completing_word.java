/*
  Problem at : https://leetcode.com/problems/shortest-completing-word/
*/

class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] mapO = new int[26];
        int letterCount = 0;
        for(char c : licensePlate.toCharArray()){
            if(Character.isLetter(c)){
                ++letterCount;
                int index = Character.isUpperCase(c) ? c - 'A' : c - 'a';
                mapO[index]++;
            }
        }
        int minLen = Integer.MAX_VALUE;
        String res = "";
        for(String word : words){
            int len = word.length();
            if(len < minLen){
                int count = 0;
                int[] map = new int[26];
                System.arraycopy(mapO, 0, map, 0, 26);
                for(char c : word.toCharArray()){
                    if(map[c - 'a']-- > 0){
                        ++count;
                    }
                }
                if(count == letterCount){
                    res = word;
                    minLen = len;
                }
            }
        }
        return res;
    }
}

// A beautiful approach using prime-factorization (credit doesn't go to me)
class Solution {
    private static final int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 
                                          67, 71, 73, 79, 83, 89, 97, 101}; 
    
    public String shortestCompletingWord(String licensePlate, String[] words) {
        long charProduct = getCharProduct(licensePlate.toLowerCase());
        String shortest = "aaaaaaaaaaaaaaaa"; 
        for(String word : words)
            if (word.length() < shortest.length() && getCharProduct(word) % charProduct == 0)
                shortest = word;
        return shortest;
    }
    
    private long getCharProduct(String plate) {
        long product = 1L;
        for(char c : plate.toCharArray()) {
            int index = c - 'a';
            if (0 <= index && index <= 25) 
                product *= primes[index];
        }
        return product;
    }
}


