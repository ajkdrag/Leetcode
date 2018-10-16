/*
  Problem at : https://leetcode.com/problems/swap-nodes-in-pairs/description/
  Algo : 
    We use two pointers to perform the swapping. One node points to the 1st of a pair, and the other is one behind.
    Before doing all this, we first insert a dummy node at the beginning of the list.
    Thus we have :  D --> 1 --> 2 --> 3 --> 4
    The 1st pointer 'x' points to D and the other pointer 'y' points to D.next i.e 1
    Swapping is done as follows : 
      x.next = y.next           ==> D --> 2 --> 3 --> 4
      y.next = y.next.next      ==> 1 --> 3 --> 4
      x.next.next = y           ==> D --> 2 --> 1 --> 3 --> 4
      
    Next we move the pointers as follows : 
      x = y                     ==> 'x' now points to 1
      y = y.next                ==> 'y' now points to node next to 1 i.e 3
      
    Repeat this process until : (y != null && y.next != null)
    (y.next != null) for the case when there are odd number of nodes and 'y' will point to the last node without a pair.
*/

class Solution {
    public ListNode swapPairs(ListNode head) {
        // dummy node placement
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        // two pointers 'x' and 'y'
        ListNode x = dummy;
        ListNode y = dummy.next;
        
        // loop condition as stated in the algo
        while(y!= null && y.next != null){
            // swap 
            x.next = y.next;
            y.next = y.next.next;
            x.next.next = y;
            // move pointers further
            x = y;
            y = y.next;
        }
        // we don't need to return dummy node, so skip it and return head.next
        return head.next;
    }
}


