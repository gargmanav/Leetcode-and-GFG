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
    public ListNode oddEvenList(ListNode head) {
      if (head == null || head.next == null) return head;

        ListNode odd = head;              // starting from 1st node
        ListNode even = head.next;        // starting from 2nd node
        ListNode evenHead = even;         // to attach later at end of odd list

        while (even != null && even.next != null) {
            odd.next = even.next;         // link odd to next odd node
            odd = odd.next;

            even.next = odd.next;         // link even to next even node
            even = even.next;
        }

        odd.next = evenHead;              // attach even list at end of odd list
        return head;
    }
}