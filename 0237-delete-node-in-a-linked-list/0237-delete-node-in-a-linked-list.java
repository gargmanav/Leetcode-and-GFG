/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
           ListNode sample = node.next;
           node.val = sample.val;
           node.next = node.next.next;
    }
}