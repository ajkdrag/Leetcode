/*
  Problem at : https://leetcode.com/problems/letter-case-permutation/
*/

// General Recursive Approach
class Solution {
    public List<String> letterCasePermutation(String S) {
        return helper(S);
    }
    
    public List<String> helper(String S){
        List<String> res = new ArrayList<String>();
        if(S.length() == 0){
            res.add("");
            return res;
        }
        if(S.length() == 1){
            char x = S.charAt(0);
            res.add(String.valueOf(x));
            if(Character.isUpperCase(x))
                res.add(Character.toString(Character.toLowerCase(x)));
            else if(Character.isLowerCase(x))
                res.add(Character.toString(Character.toUpperCase(x)));
            return res;
        }
            
        List<String> soFar = helper(S.substring(1));
        StringBuilder sb = new StringBuilder();
        char c = S.charAt(0);
        for(String s : soFar){
            sb.append(c);
            sb.append(s);
            res.add(sb.toString());
            sb.setLength(0);
            if (Character.isLowerCase(c)) {
                sb.append(Character.toUpperCase(c));
                sb.append(s);
                res.add(sb.toString());
            } else if(Character.isUpperCase(c)){
                sb.append(Character.toLowerCase(c));
                sb.append(s);
                res.add(sb.toString());
            }
            sb.setLength(0);
        }
        return res;
    }
}

// Backtracking
class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList();
        char[] nums = S.toCharArray();
        backTrack(nums , list , 0);
        return list;
    }
    public void backTrack(char[] nums , List<String> list , int start){
        list.add(new String(nums));
        for(int i = start;i < nums.length;i++){
            char c = nums[i];
            if(Character.isUpperCase(c)){
                nums[i]= Character.toLowerCase(c);
                backTrack(nums,list,i+1);
                nums[i] = Character.toUpperCase(c);
                continue;
            }
            if(Character.isLowerCase(c)){
                nums[i]= Character.toUpperCase(c);
                backTrack(nums,list,i+1);
                nums[i] = Character.toLowerCase(c); 
            }    
        }
    }
}


