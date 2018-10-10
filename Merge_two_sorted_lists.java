/*
  Problem at : https://leetcode.com/problems/merge-two-sorted-lists/
  We can simply create a new List and apply the "merge" algorithm to the given lists thereby appending the
  smaller elements one by one to the new List.
  Here in this implementation, I made it a bit challenging by not creating a new List and making the resultant list 
  in the first list itself. i.e the smaller elements are appending to the first list itself and not to a temp/new list.
*/

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // trivial cases
        if(l1 == null && l2 == null) return l1;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode i = l1;
        ListNode j = l2;
        ListNode k = l1;
        ListNode temp = null;
        
        // 'k' must always be behind 'i'
        if(l1.val >= l2.val){
            temp = j;
            j = j.next;
            temp.next = i;
            l1 = temp;
            k = temp;
        }
        
        while(i !=null && j !=null){
            // if node val at 'i' is <= node val at 'j', move points of l1 ahead (make sure 'k' is always behind 'i')
            if(i.val <= j.val){
                // to make 'k' behind 'i'
                if(i == k) i = i.next;
                else {
                    i = i.next;
                    k = k.next;
                }
            }
            // otherwise, place the node pointed by 'j' in between 'k' and 'i' and move 'j'
            else {
                temp = j;
                j = j.next;
                temp.next = k.next;
                k.next = temp;
                k = temp;
            }
        }
        
        // if some elements of 'j' are still left to be checked, 
        // they must all be >= node vals of l1, thus append them all to l1
        if(j != null) k.next = j;
        
        // l1 is the resultant list, so return it
        return l1;
    }
}


