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
        if (lists == null || lists.length == 0) {
            return null;
        }
        while (lists.length > 1) {
            ListNode[] merged = new ListNode[lists.length % 2 == 0 ? lists.length / 2 : lists.length / 2 + 1];
            int index = 0;
            for (int i = 0; i < lists.length; i += 2) {
                ListNode first = lists[i];
                ListNode second = i + 1 < lists.length ? lists[i + 1] : null;
                merged[index++] = mergeLists(first, second);
            }
            lists = merged;
        }
        return lists[0];
    }

    private ListNode mergeLists(ListNode first, ListNode second) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (first != null && second != null) {
            if (first.val < second.val) {
                curr.next = first;
                first = first.next;
            } else {
                curr.next = second;
                second = second.next;
            }
            curr = curr.next;
        }
        if (first != null) {
            curr.next = first;
        }
        if (second != null) {
            curr.next = second;
        }
        return dummy.next;
    }
}
