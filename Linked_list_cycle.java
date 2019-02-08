/*
  Problem at : https://leetcode.com/problems/linked-list-cycle/
*/

class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode normal = head;
        if(head == null || head.next == null)
            return false;
        ListNode fast = head.next.next;
        while(normal != fast){
            if(fast == null || fast.next == null)
                return false;
            normal = normal.next;
            fast = fast.next.next;
        }
        return true;
    }
}


