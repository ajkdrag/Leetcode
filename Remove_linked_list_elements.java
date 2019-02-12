/*
  Problem at https://leetcode.com/problems/remove-linked-list-elements/: 
*/

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        ListNode runner = head;
        while(runner != null && runner.next !=  null){
            if(runner.next.val == val)
                runner.next=runner.next.next;
            else
                runner = runner.next;
        }
        return head.next;
    }
}


