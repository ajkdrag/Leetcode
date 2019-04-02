/*
  Problem at : 
*/

// without modulus op. (unreadable)
class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        int curr = 0;
        List<Boolean> res = new ArrayList();
        for(int i : A){
            res.add(curr == (i<<1));
            curr = (curr<<1)+i;
            if(curr >= 5)
                curr-=5;
        }
        return res;
    }
}

// with modulus op. (readable)
class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
    List<Boolean> ans = new ArrayList<>(A.length);
    int t = 0;

    for (int n : A) {
      t = ((t << 1) + n) % 5;
      ans.add(t == 0);
    }

    return ans;
    }
}


