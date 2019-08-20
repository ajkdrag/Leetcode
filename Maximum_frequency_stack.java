/*
  Problem at : https://leetcode.com/problems/maximum-frequency-stack/submissions/
*/

class FreqStack {
    int max;
    Stack<Integer>[] stArr;
    Map<Integer, Integer> cnt;
    public FreqStack() {
        max = -1;
        stArr = new Stack[10001];
        for(int i = 0; i <= 10000; ++i)
            stArr[i] = new Stack<Integer>();
        cnt = new HashMap<Integer, Integer>();
    }
    
    public void push(int x) {
        int pos = 1 + cnt.getOrDefault(x, 0);
        stArr[pos].push(x);
        cnt.put(x, pos);
        max = pos > max ? pos : max;
    }
    
    public int pop() {
        int op = stArr[max].pop();
        cnt.put(op, cnt.get(op)-1);
        while(max > 0 && stArr[max].isEmpty()){
            --max;
        }
        return op;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
 
 
