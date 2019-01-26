/*
  Problem at : https://leetcode.com/problems/delete-node-in-a-linked-list/
*/

// naive way
class Solution {
    public void deleteNode(ListNode node) {
        ListNode curr = node;
        ListNode prev = curr;
        while(curr.next != null){
            curr.val = curr.next.val;
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
    }
}

// concise and better
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

