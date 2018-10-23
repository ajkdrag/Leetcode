/*
  Problem at : https://leetcode.com/problems/reverse-nodes-in-k-group/
  Algo : length of linked list / k will give the number of times we are supposed to reverse a group of size k
  Thus, having found that, we now need to figure out how to reverse a group of size k.
  We can use three pointers : prev, i and j which are as follows : 
  
  eg : D --> 1 --> 2 --> 3 --> 4 --> 5  {D = Dummy node which we append before the list}
      prev   i     j
      
      We store node at j in another temporary pointer 't'. In order to reverse, we do t.next = i and then move i and j
      forward : i = t; j = j.next;
      We do this until we are done with all members of this k-group.
      Finally, once we are done reversing ; we will have something like this for k = 4
      
      D --> 1 <--> 2 <-- 3 <-- 4    5     {Note the <--> because 1.next = 2 link is unaffected}
      prev                     i    j
      
      Next, we do : 
      prev.next.next = j :            D --> 1 <-- 2 <-- 3 <-- 4   and  1 --> 5
      we store prev.next in t :      prev   t                 i        t     j
      prev.next = i :                 D --> 4 --> 3 --> 2 --> 1 --> 5
      prev = t                              i                 prev  j
     
      Now we have properly reversed the list
      if (j == null) we don't need to do anything more, since we are at the end of the list now so return head.next
      else : for the next reversal of the next k-group, we need to set the pointers i and j properly, so we do :
      i = j
      j = j.next
*/

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // trivial cases
        if(head == null || head.next == null || k < 2) return head;
        int counter = 1;
        // append dummy node to start of list
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        ListNode prev = dummy;
        ListNode i = prev.next;
        // find the length of the list
        int len = 0;
        while(i!=null){
            ++len;
            i = i.next;
        }
        // if len < k, we don't need to do any reversals
        if(len < k) return head.next;
        // place the pointers i and j at their initial positions 
        i = prev.next;
        ListNode j = prev.next.next;
        ListNode t = null;
        // len now means the number of times we need to perform reversals of a k-group
        len = len/k;
        while(len-- > 0){
            // for a k-group, the number of reversals needed is k-1 so we count using counter
            counter = 1;
            while(counter < k){
                // perform reversals as described in the algo
                t = j;
                j = j.next;
                t.next = i;
                i = t;
                ++counter;
            }
            // properly reverse the list 
            prev.next.next = j;
            t = prev.next;
            prev.next = i;
            prev = t;
            // if we are at the end of the list, we need not loop anymore
            if(j == null) break;
            // else, place the pointers i, and j at proper positions for the next k-group
            i = j;
            j = j.next;
        }
        // make sure to skip the dummy node
        return head.next;
    }
}


