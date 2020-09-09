/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode previous = head;
        ListNode curr = previous.next;
        
        while(curr != null) {
            if(previous.val == curr.val) {
                previous.next = curr.next;  
            } else {
                previous = previous.next;
            }
            
            curr = curr.next;
        }
        return head;
    }
}