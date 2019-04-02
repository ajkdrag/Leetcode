/*
  Problem at : https://leetcode.com/problems/find-common-characters/
*/

class Solution {
    HashMap<String, Integer> res;
    public List<String> commonChars(String[] A) {
        res = new HashMap<String, Integer>();
        List<String> commChars = new ArrayList();
        for(char ch : A[0].toCharArray()){
            String c = Character.toString(ch);
            res.put(c, 1 + res.getOrDefault(c, 0));
        }
        int len = A.length;
        while(len-- > 0){
            if(!helper(A, len, (HashMap<String, Integer>)res.clone())){
                return commChars;   
            }
        }
        for(String s : res.keySet()){
            int occured = res.get(s);
            while(occured-- > 0){
                commChars.add(s);
            }
        }
        return commChars;
    }
    
    boolean helper(String[] A, int index, HashMap<String, Integer> soFar){
        res.clear();
        String curr = A[index];
        boolean found = false;
        for(char ch : curr.toCharArray()){
            String c = Character.toString(ch);
            int occurence = soFar.getOrDefault(c, 0);
            if(occurence > 0){
                found = true;
                soFar.put(c, occurence - 1);
                res.put(c, res.getOrDefault(c, 0) + 1);
            }
        }
        return found;
    }
}

// same approach as above but using mask array instead of hashmap
class Solution {
    public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        int[] mask = new int[26];
         scan(A[0],mask);
        
        for(int i=1; i < A.length; i++){
            int[] cur = new int[26];
            scan(A[i],cur);
            for(int j=0;j<26;j++){
                mask[j]= mask[j]<cur[j]?mask[j]:cur[j];
            }
        }
        
        for(int i=0; i < 26 ; i++){
            for(int j =0;j<mask[i];j++)
                result.add(Character.toString((char)(i + 'a')));
        }
        return result;
    }
    
    public void scan(String s,int[] arr){
        for(char c : s.toCharArray())
            arr[c-'a']++;
    }
}

