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

    private ListNode reverseRecursion(ListNode head, ListNode prev) {
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            head.next = prev;
            return head;
        }
        ListNode next = head.next;
        head.next = prev;
        return reverseRecursion(next, head);
    }

    public ListNode reverseList(ListNode head) {
        return reverseRecursion(head, null);
    }
}
