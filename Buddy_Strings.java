/*
  Problem at : https://leetcode.com/problems/buddy-strings/
*/

class Solution {
    public boolean buddyStrings(String A, String B) {
        boolean foundDuplicates = false;
        HashSet<Character> charSet = new HashSet<Character>();
        int lenA = A.length();
        int lenB = B.length();
        if(lenA != lenB)
            return false;
        int mismatchCount = 0;
        char pairA = '0';
        char pairB = '0';
        char A_ = '0';
        char B_ = '0';
        for(int i = 0; i < lenA; ++i){
            A_ = A.charAt(i);
            B_ = B.charAt(i);
            charSet.add(A_);
            if(A_ == B_){
                continue;
            }
            if(mismatchCount == 0){
                pairA = A_;
                pairB = B_;
                ++mismatchCount;
                continue;
            }
            if(mismatchCount > 1 || !(A_ == pairB && B_ == pairA)){
                return false;
            }
            ++mismatchCount;
        }
        if(mismatchCount == 0)
            return charSet.size() < lenA;
        return true;
    }
}


