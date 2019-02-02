/*
  Problem at : https://leetcode.com/problems/binary-watch/
*/

// non recursive solution
class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> times = new ArrayList<>();
        for (int h=0; h<12; h++)
            for (int m=0; m<60; m++)
                if (Integer.bitCount((h<<6) + m) == num)
                    times.add(String.format("%d:%02d", h, m));
        return times;        
    }
}

// using backtracking
class Solution {
    List<String> res;
    public List<String> readBinaryWatch(int num) {
        res= new ArrayList<>();
        rec(0,num,0,0);
        return res;
    }
    public void rec(int index, int num, int hour, int min) {
    		if (hour > 11 || min > 59) return;
    		if (num ==0) {
    			res.add(getTime(hour,min));
    			return;
    		}
    		for(int i = index; i < 10;i++) {
    			if (i<4) {
    				rec(i+1, num-1, hour + (1<<i),min);
    			}else {
    				rec(i+1, num-1, hour, min +(1 << (i - 4)));
    			}
    		}
    }
    public String getTime(int hour, int min) {
    		StringBuilder str = new StringBuilder();
    		str.append(hour).append(":").append(min < 10?"0":"").append(min);
    		return str.toString();
    }
}


