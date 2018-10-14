/*
  Problem at : https://leetcode.com/problems/merge-k-sorted-lists/
  Solution article at : https://leetcode.com/problems/merge-k-sorted-lists/solution/
  
  Below implementation is based on the priority queue based algorithm.
*/

class Solution {
    public ListNode mergeKLists(ListNode[] lists) { 
        // comparator implementation for comparing two nodes of a list
        Comparator<ListNode> cmp;
        cmp = new Comparator<ListNode>() {  
            @Override
            public int compare(ListNode o1, ListNode o2) {
                // +ve is o1 > o2, -ve if o1 < o2, 0 if equal
                return o1.val-o2.val;
            }
        };
 
        Queue<ListNode> q = new PriorityQueue<ListNode>(cmp);
        // put the heads of the lists in the pqueue
        for(ListNode l : lists){
            if(l!=null){
                q.add(l);
            }        
        }
        // new list node to which nodes will be appended one by one as we "extract min" from the pqueue
        ListNode head = new ListNode(0);
        // point always points to the last node of the result list, so that appending can be done in O(1)
        ListNode point = head;
        
        while(!q.isEmpty()){ 
            // poll the min node from the pqueue (i.e extract min) and append to the result list
            point.next = q.poll();
            // move the tail pointer of the result list
            point = point.next; 
            // the polled node belonged to some list, we append the next node of that list to the pqueue if it's not null
            ListNode next = point.next;
            if(next!=null){
                q.add(next);
            }
        }
        // return the result list's head
        return head.next;
    }
}


/*
  Another method that is based on divide and conquer approach (could be done recursively as well)
*/

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        if (lists.length == 2) return merge(lists[0],lists[1]);
        int interval = 1;
        // similar to bottom-up merge sort
        while (interval < lists.length) {
            for (int i = 0; i < lists.length - interval; i = i + (interval << 1)) {
                lists[i] = merge(lists[i], lists[i + interval]);
            }
            interval <<= 1;
        }
        return lists[0];
    }
    
    // function to merge two sorted lists
    private ListNode merge(ListNode p, ListNode q) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        while (p != null && q != null) {
            if (p.val < q.val) {
                pre.next = p;
                p = p.next;
            } else {
                pre.next = q;
                q = q.next;
            }
            pre = pre.next;
        }
        if (p != null) {
            pre.next = p;
        } else {
            pre.next = q;
        }
        return dummy.next;
    }
}


