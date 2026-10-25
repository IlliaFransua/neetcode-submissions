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
    private int calculateSize(ListNode[] lists) {
        int res = 0;
        for (var node : lists) {
            var curr = node;
            while (curr != null) {
                ++res;
                curr = curr.next;
            }
        }
        return res;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int size = calculateSize(lists);
        List<Integer> all = new ArrayList<>(size);
        for (var node : lists) {
            var curr = node;
            while (curr != null) {
                all.add(curr.val);
                curr = curr.next;
            }
        }
        mergeSort(all);
        ListNode left = new ListNode(0);
        ListNode curr = left;
        for (var n : all) {
            curr.next = new ListNode(n);
            curr = curr.next;
        }
        return left.next;
    }

    private Integer[] buffer;

    private void mergeSort(List<Integer> pairs) {
        if (pairs == null || pairs.isEmpty()) return;
        buffer = new Integer[pairs.size()];
        mergeSort(pairs, 0, pairs.size() - 1);
    }

    private void mergeSort(List<Integer> pairs, int left, int right) {
        if (left == right) return;
        int mid = (left + right) / 2;
        mergeSort(pairs, left, mid);
        mergeSort(pairs, mid + 1, right);
        merge(pairs, left, mid, right);
    }

    private void merge(List<Integer> pairs, int left, int mid, int right) {
        int l1_left = left;
        int l1_right = mid;
        int l2_left = mid + 1;
        int l2_right = right;
        int i = 0;

        while (l1_left <= l1_right && l2_left <= l2_right) {
            if (pairs.get(l1_left) <= pairs.get(l2_left)) {
                buffer[i++] = pairs.get(l1_left++);
            } else {
                buffer[i++] = pairs.get(l2_left++);
            }
        }
        while (l1_left <= l1_right) {
            buffer[i++] = pairs.get(l1_left++);
        }
        while (l2_left <= l2_right) {
            buffer[i++] = pairs.get(l2_left++);
        }
        --i;

        while (i >= 0) {
            pairs.set(right--, buffer[i--]);
        }
    }
}
