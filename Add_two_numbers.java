/*
  Problem at : https://leetcode.com/problems/add-two-numbers-ii/
*/

// stack based solution
class Solution {
    ListNode pt1, pt2;
    int a, carry;
    Stack<Integer> st1, st2;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        pt1 = l1;
        pt2 = l2;
        st1 = new Stack<Integer>();
        st2 = new Stack<Integer>();
        while(pt1 != null){
            st1.push(pt1.val);
            pt1 = pt1.next;
        }
        while(pt2 != null){
            st2.push(pt2.val);
            pt2 = pt2.next;
        }
        ListNode tail = null;
        ListNode sum = null;
        carry = 0;
        while(!st1.isEmpty() && !st2.isEmpty()){
            a = st1.pop();
            a += st2.pop() + carry;
            carry = 0;
            if(a >= 10){
                a -= 10;
                carry = 1;
            }
            sum = new ListNode(a);
            sum.next = tail;
            tail = sum;
        }
        while(!st1.isEmpty()){
            int a = st1.pop();
            a += carry;
            carry = 0;
            if(a >= 10){
                a-=10;
                carry = 1;
            }
            sum = new ListNode(a);
            sum.next = tail;
            tail = sum;
        }
        while(!st2.isEmpty()){
            int a = st2.pop();
            a += carry;
            carry = 0;
            if(a >= 10){
                a-=10;
                carry = 1;
            }
            sum = new ListNode(a);
            sum.next = tail;
            tail = sum;
        }
        if(carry > 0){
            sum = new ListNode(carry);
            sum.next = tail;
        }
        return sum;
        
    }
}


