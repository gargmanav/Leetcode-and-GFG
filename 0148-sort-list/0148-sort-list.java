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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

    List<Integer> values = new ArrayList<>();
    ListNode curr = head;
    while (curr != null) {
        values.add(curr.val);
        curr = curr.next;
    }

    Collections.sort(values);

    curr = head;
    for (int val : values) {
        curr.val = val;
        curr = curr.next;
    }

    return head;
    }
}