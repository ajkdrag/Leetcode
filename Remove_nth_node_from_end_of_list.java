/*
  Problem at : https://leetcode.com/problems/remove-nth-node-from-end-of-list/
  Solution at : https://leetcode.com/problems/remove-nth-node-from-end-of-list/solution/
  Use of two pointers, where one pointer is ahead of the other by 'n' nodes
  Now that one pointer is ahead of the other by 'n' nodes. Run both pointers at "same speed"
  i.e advance each of them one node at a time. Eventually, the pointer that was ahead will reach the 'end' node 1st
  and when it reaches the end node, the other pointer will be sitting at one node behind the one that needs to be removed.
  Note the case when number of nodes in total is equal to 'n'. In this case, the pointer after being 'n' steps ahead will
  now be pointing to a null node. In this case, we can be sure that the other pointer is pointing to the node that needs to
  be removed. Simply return head.next in that case.
*/

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode i = head;
        ListNode j = head;
        // move one pointer ahead 'n' units
        while(n-- > 0){
            j = j.next;
        }
        // if we reached null with the other pointer, then it means that the node which 'i' points at needs to be removed
        // simply return head.next
        if(j == null) return head.next;
        // loop till 'j' reaches the last node
        // then i.next will be the node that needs to be removed
        while(j.next != null){
            i = i.next;
            j = j.next;
        }
        // remove i.next and return head
        i.next = i.next.next;
        return head;
    }
}


