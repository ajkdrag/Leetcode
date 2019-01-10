/*
  Problem at : https://leetcode.com/problems/unique-email-addresses/
*/

class Solution {
    // hashset to store the unique email addresses
    HashSet<String> email_list;
    StringBuilder sb;
    
    public int numUniqueEmails(String[] emails) {
        email_list = new HashSet<>();
        sb = new StringBuilder();
        
        for(int i = emails.length - 1; i >= 0; --i){
            String email = emails[i];
            // isDomain set to true implies we will now scan the part after @
            boolean isDomain = false;
            // firstPlus set to true implies we will now scan part after seeing the first + sign
            boolean firstPlus = false;
            for(char c : email.toCharArray()){
                // we found @, i.e after this, the characters are part of the domain name
                if(c == '@'){
                    isDomain = true;
                    sb.append(c);
                    continue;
                }
                // if we see '.' and we are not in domain name (i.e in local name), then we ignore (i.e continue)
                if(c == '.' && !isDomain)
                    continue;
                // if we see '+' and we are in local name, then we ignore and mark (for ignoring further characters)
                if(c == '+' && !isDomain){
                    firstPlus = true;
                    continue;
                }
                // if we have see a first '+', and we are in the local name, we ignore the characters
                if(firstPlus && !isDomain){
                    continue;
                }
                // append everything else
                sb.append(c);
            }
            email_list.add(sb.toString());
            sb.setLength(0);
        }
        // return the size of the set which now contains unique addresses
        return email_list.size();
    }
}


