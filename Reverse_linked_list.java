/*
  Problem at : https://leetcode.com/problems/reverse-linked-list/
*/

// Iterative versions are common, so went for the recursive one.
class Solution {
    public ListNode reverseList(ListNode head) {
        return helper(head, null);
    }
    
    ListNode helper(ListNode curr, ListNode prev){
        if(curr == null)
            return prev;
        ListNode temp = curr.next;
        curr.next = prev;
        return helper(temp, curr);
    }
}


