/*
  Problem at : https://leetcode.com/problems/min-stack/
*/

class MinStack {
    /** initialize your data structure here. */
    ArrayList<Integer> minList;
    ArrayList<Integer> st;
    int top;
    int minTop;
    int sz;
    int minsz;
    public MinStack() {
        st = new ArrayList<Integer>();
        minList = new ArrayList<Integer>();
        top = -1;
        minTop = -1;
        sz = -1;
        minsz = -1;
    }
    
    public void push(int x) {
        if(top+1 <= sz){
            st.set(++top, x);
        }
        else {
            st.add(x);
            ++top;
            ++sz;
        }
        
        if(minTop == -1 || x <= minList.get(minTop)){
            if(minTop +1 <= minsz){
                minList.set(++minTop, x);
            }
            else {
                minList.add(x);
                ++minTop;
                ++minsz;
            }
        }
    }
    
    public void pop() {
        if(st.get(top).equals(minList.get(minTop))){
            --minTop;
        }
        --top;
    }
    
    public int top() {
        return st.get(top);
    }
    
    public int getMin() {
        return minList.get(minTop);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
 
 
 
