/*
  Problem at : https://leetcode.com/problems/largest-time-for-given-digits/
*/

// bootlegged solution
class Solution {
    public String largestTimeFromDigits(int[] A) {
        int h1 = 3;
        int h2 = 3;
        Arrays.sort(A);
        boolean foundB = false;
        boolean done2 = false;
        boolean done1 = false;
        int[] hrs = new int[2];
        int[] mins = new int[2];
        for(int i = 0; i < 2; ++i){
            hrs[i] = -1;
            mins[i] = -1;
        }
        for(; h1 >= 0; --h1){
            if(!done2 && A[h1] == 2){
                done2 = true;
                hrs[0] = -1;
                hrs[1] = -1;
                mins[0] = -1;
                mins[1] = -1;
                foundB = false;
                h2 = 3;
                while(h2 >= 0){
                    if(h2 == h1){
                        h2--;
                        continue;
                    }
                    int val = A[h2];
                    if(!foundB && val < 4){
                        foundB = true;
                        hrs[0] = 2;
                        hrs[1] = val;
                    }
                    else if(val > 5){
                        mins[1] = val;
                    }
                    else{
                        if(mins[0] != -1)
                            mins[1] = val;
                        else
                            mins[0] = val;
                    }
                    --h2;
                }
                if(hrs[1] != -1 && mins[0] != -1 && mins[1] != -1)
                    return "" + hrs[0] + hrs[1] + ":" + mins[0] + mins[1];
            }
            
            if(!done1 && A[h1] <= 1){
                done1 = true;
                h2 = 3;
                hrs[0] = -1;
                hrs[1] = -1;
                mins[0] = -1;
                mins[1] = -1;
                foundB = false;
                while(h2 >= 0){
                    if(h2 == h1){
                        h2--;
                        continue;
                    }
                    int val = A[h2];
                    if(!foundB && val < 10){
                        foundB = true;
                        hrs[0] = A[h1];
                        hrs[1] = val;
                    }
                    else if(val > 5){
                        mins[1] = val;
                    }
                    else{
                        if(mins[0] != -1)
                            mins[1] = val;
                        else
                            mins[0] = val;
                    }
                    --h2;
                }
                if(hrs[1] != -1 && mins[0] != -1 && mins[1] != -1)
                    return "" + hrs[0] + hrs[1] + ":" + mins[0] + mins[1];
            }
        }
        
        return "";
    }
}

// concise soln
class Solution {
    public String largestTimeFromDigits(int[] A) {
        Arrays.sort(A);
        for (int i = 3; i >= 0; i--)
            if (A[i] <= 2)
                for (int j = 3; j >= 0; j--)
                    if ((A[i] != 2 || A[j] <= 3) && i != j)
                        for (int k = 3; k >= 0; k--)
                            if (A[k] <= 5 && i != k && j != k)
                                return "" + A[i] + A[j] + ":" + A[k] + A[6 - i - j - k];
        return "";
    }
}


