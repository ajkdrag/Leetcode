/*
  Problem at : https://leetcode.com/problems/remove-duplicates-from-sorted-list/
*/

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = head;
        if(prev == null)
            return head;
        ListNode curr = head.next;
        while(curr != null){
            if(curr.val == prev.val){
                prev.next = curr.next;
                curr = prev.next;
            }
            else{
                curr = curr.next;
                prev = prev.next;
            }
        }
        return head;
    }
}


