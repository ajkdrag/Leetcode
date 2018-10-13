/*
   Problem at : https://leetcode.com/problems/generate-parentheses/
   Solution article at : https://leetcode.com/problems/generate-parentheses/solution/
   
   Method 1 : 
   A slightly different implementation. Here we assume '0' to represent an open brace and '1' for a closing parens.
   Thus, every valid combination can be expressed in binary and has some decimal value.
   The starting value for n == 3 is : "000111" which is 7 in decimal
   and it's ending value is "010101" which is 21 in decimal and all other valid combs will lie between 7 and 21.
   7 = 2*3 - 1, and 21 = (4^3 - 1)/(4 - 1) = (2^6 - 1)/3
   Thus, start = (1<<n) - 1, end = ((1<<(n<<1)) - 1)/3
   Thus, we iterate through 7 and 21 (both inclusive) and check if a number a valid combination or not.
   If a valid combination is found, we simply replace all 0's with '(' and all 1's with ')'
   A valid combination is such that : number of 1's and 0's are equal and when we check from left to right,
   the number of closing parens at any instance should be <= the number of opening parens.
*/

class Solution {
	static List < String > generateParenthesis(int n) {
		List < String > res = new ArrayList < String > ();
		// trivial case
		if (n == 1) {
			res.add("()");
			return res;
		}

		int noOfBits = n << 1;
		int start = (1 << n) - 1;
		int end = ((1 << (n << 1)) - 1) / 3;

		for (int i = start; i <= end; i += 2) {
			if (!isValid(i, noOfBits)) continue;
			res.add(prependZeros(Integer.toBinaryString(i), noOfBits).replaceAll("0", "(").replaceAll("1", ")"));
		}

		return res;
	}

	// method to check whether a combination is valid or not
	static boolean isValid(int num, int bits) {
		int openCnt = 0;
		int closeCnt = 0;
		for (int i = bits - 1; i >= 0; --i) {
			if ((num & (1 << i)) > 0) closeCnt++;
			else openCnt++;
			if (closeCnt > openCnt) return false;
		}
		return closeCnt == openCnt;
	}

	// prepend 0's to form the complete combination of length (2*n)
	static String prependZeros(String bitStr, int bits) {
		int diff = bits - bitStr.length();
		String newBitStr = bitStr;
		for (int i = 0; i < diff; ++i) {
			newBitStr = "0" + newBitStr;
		}
		return newBitStr;
	}
}

/*
  Method 2: Using backtracking
  Here, we generate the valid parens in the following manner. We use variables called 'toClose' and 'open'
  which depicts the number of opened parens and the total number of open parens available.
  If toClose == 0, that means we haven't used any of the opening parens so far, 
  thus in that case, we use an opening paren and thus reduce open by 1 (because we used one) and increase toClose by 1.
  if suppose we use up all the opening paren, then in that case, open will be 0. Now we need to simply put 
  as many closing braces as are needed (which is denoted by toClose variable)
  In case, neither open == 0, nor toClose == 0, then it means that we have used 'some opening parens', but not all,
  then in that case we can either choose to 'use another opening paren' or 'close the opened parens' thereby making toClose = 0,
  The implementation sort of combines two checks, because we can choose to 'use another opening paren' in both the cases
  when we have toClose == 0 and also when neither open == 0, nor toClose == 0.
  In other words, we have the choice to use an opening parens as long as open > 0
  The choice of using a closing parens comes when toClose > 0 and this choice becomes a compulsion when open == 0
*/

class Solution {
	static List < String > res;
	static List < String > generateParenthesis(int n) {
		res = new ArrayList < String > ();
		// trivial case
		if (n == 1) {
			res.add("()");
			return res;
		}

		StringBuilder sb = new StringBuilder();
		helper(sb, n, 0);
		return res;
	}

	static void helper(StringBuilder sb, int open, int toClose) {
		// if open == 0, we have no other choice but to use closing parens
		if (open == 0) {
			// toClose denotes the number of closing parens needed.
			while (toClose-->0) sb.append(")");
			res.add(sb.toString());
			return;
		}
		else {
			// if(open > 0) this means that we have availability of opening parens. So we can use them.
			helper(new StringBuilder(sb.toString()).append("("), open - 1, toClose + 1);
			// Alose, if toClose > 0, this means that we also can choose to use closing parens
			// because, there are some opening parens that aren't matched with any closing paren.
			if (toClose != 0) helper(new StringBuilder(sb.toString()).append(")"), open, toClose - 1);
		}
	}
}


