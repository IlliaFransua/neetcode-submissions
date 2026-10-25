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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (true) {
            int min_node = -1;
            for (int i = 0; i < lists.length; ++i) {
                if (lists[i] == null) {
                    continue;
                }
                if (min_node == -1 || lists[i].val < lists[min_node].val) {
                    min_node = i;
                }
            }
            if (min_node == -1) {
                break;
            }
            curr.next = lists[min_node];
            lists[min_node] = lists[min_node].next;
            curr = curr.next;
        }
        return dummy.next;
    }
}
