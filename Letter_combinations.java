/*
    Problem at : https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
    
    Algo :  Create a hashmap mapping the digits to their possible alphabet counterparts to ease things
            Use a mask array 'A' such that A[i] signifies which alphabet corresponding to digit 'i' should be taken    
           
            eg :    map = {2 : (a, b, c)}  
            
            A[2] = 0 ==> 'a'    because index 0 of map.get(2) is 'a'
            A[2] = 1 ==> 'b'    because index 1 of map.get(2) is 'b'
            and so on...
            
            Thus if digits string is "234" and our mask array A = {2,0,0}
            this implies the corresponding letter combination is "cdg"
            
            Now only thing left is to somehow have the values in the mask array range over all possible letter combinations.
            Total number of letter combinations of the digit string = product of number of letter combinations of each digit
            And to loop through all such combinations we need to basically loop our mask array through all the "valid combinations"
            This can be easily done by simply incrementing the mask by 1 each iteration.
            
            eg: mask array A starts with value : {0, 0, 0}
            and suppose digits string = "239"
            Note that total number of letter combinations = 3 * 3 * 4 = 36 which is the required number of iterations
            we increment our mask by 1 each iteration i.e
            
            2 3 9
            -----
            0 0 0 
            0 0 1
            0 0 2
            0 0 3  <-- Note that total number of letter combinations for digit 9 is 4 and since we start from 0, we go till only 3
            0 1 0  <-- Once we reached 3, we should go then back to 0 and generate a carry to the previous digit (ripple carry add)
            0 1 1
            . . .
            . . .
            . . .
            2 2 3
            -----
            
            Thus, we implement our own adder to perform this ripple carry addition, keeping in mind the max values for each mask entry.
            In the below implementatiion, same procedures are followed, except for the fact that the addition is performed from LHS
            i.e we have : 0 0 0 --> 1 0 0 --> 2 0 0 --> 0 1 0 ...
*/

class Solution {
    HashMap<Character, char[]> map;
    int[] mask, max;
    int len;
    
    public List<String> letterCombinations(String digits) {
        len = digits.length();
        map = new HashMap<Character, char[]>();
        List<String> res = new ArrayList<String>();
        // trivial case
        if(len == 0) return res;
        
        // mask array signifies which alphabet corresponding to digit 'i' should be taken    
        // max array stores the max values each mask entry can have
        mask = new int[len];
        max = new int[len];
        
        map.put('2',new char[]{'a','b','c'});
        map.put('3',new char[]{'d','e','f'});
        map.put('4',new char[]{'g','h','i'});
        map.put('5',new char[]{'j','k','l'});
        map.put('6',new char[]{'m','n','o'});
        map.put('7',new char[]{'p','q','r','s'});
        map.put('8',new char[]{'t','u','v'});
        map.put('9',new char[]{'w','x','y','z'});
        
        // size stores the total number of letter combinations possible
        int size = 1;
        for(int i = len - 1; i>= 0; --i){
            max[i] = map.get(digits.charAt(i)).length;
            // size is obtained by multiplying individual number of possible letter combinations
            size *= max[i];
        }
        
        StringBuilder letterComb = new StringBuilder();
        while(size-- > 0){
            letterComb.setLength(0);
            for(int i = 0; i < len; ++i){
                // add the letter that the mask value corresponds to for the current digit
                letterComb.append(map.get(digits.charAt(i))[mask[i]]);
            }
            // add the formed string to the result list
            res.add(letterComb.toString());
            // increment the mask using our ripple addition implementation
            increment(mask,max);
        }
        
        return res;
    }
    
    // ripple addition implementation (here only 1 is added, i.e it performs incrementation)
    void increment(int[] mask, int[] max){
        int c = 1;
        for(int i = 0; c == 1 && i < len; ++i){
            int val = mask[i];
            val += c;
            if(val == max[i]){
                c = 1;
                val = 0;
            } 
            mask[i] = val;
        }
    }
}

/*
    Another solution based on BFS.
    ans = {""} initiallly
    digits = "23" say
    for 2, we have "abc" thus : ans = {"a","b","c"}
    for 3, we have "def" thus, remove 1st element which is 'a' and append it to all in {'d', 'e', 'f'}
    thus we get : ans = {"b","c","ad","ae","af"}
    next remove "b" and do the same.. we do it until the first element's length is not equal to the length of digits
    ans = {"c","ad","ae","af","bd","be","bf"}
    ans = {"ad","ae","af","bd","be","bf","cd","ce","cf"}
    now when we see the length of the first element in ans i.e |"ad"| = |"23"| = 2 and thus we stop and return ans.
    We could have used other data structures apart from LinkedList, but the BFS approach remains the same.
*/

class Solution {
    public List<String> letterCombinations(String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		if(digits.isEmpty()) return ans;
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		ans.add("");
		while(ans.peek().length()!=digits.length()){
			String remove = ans.remove();
			String map = mapping[digits.charAt(remove.length())-'0'];
			for(char c: map.toCharArray()){
				ans.addLast(remove+c);
			}
		}
		return ans;
	}
}


