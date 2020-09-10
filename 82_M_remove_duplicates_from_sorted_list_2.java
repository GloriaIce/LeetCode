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
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        
        ListNode pre = fakeHead;
        ListNode node = head;
        int previousValue = Integer.MIN_VALUE;
        while(node != null && node.next != null) {
            if (node.val == node.next.val || node.val == previousValue) {
                pre.next = node.next;
                previousValue = node.val;
                node = node.next;
            } else {
                node = node.next;
                pre = pre.next;
            }
        }
        
        if (node != null && node.val == previousValue) {
            pre.next = null;
        }
        
        return fakeHead.next;
    }
}