/*
  Problem at : https://leetcode.com/problems/subdomain-visit-count/
*/

class Solution {
    public static List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        String[] temp = new String[2];
        for(String domain : cpdomains){
            int count = 0;
            int j = 0;
            for(; ; ++j){
                char c = domain.charAt(j);
                if(c >= '0' && c <= '9'){
                    count = count*10 + (c - '0');
                }
                else 
                    break;
            }
            for(int i = domain.length() - 1; i >= j; --i){
                char c = domain.charAt(i);
                if(c == '.' || c == ' '){
                        String s = domain.substring(i + 1);
                        map.put(s, count + map.getOrDefault(s, 0));
                }
            }
        }
        List<String> res = new ArrayList<String>();
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            String s  = (entry.getValue() + " " + entry.getKey());
            res.add(s);
        }
        return res;
    }
}


