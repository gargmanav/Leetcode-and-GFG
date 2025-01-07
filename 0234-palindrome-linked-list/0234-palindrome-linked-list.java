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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true; // Single node or empty list is a palindrome.
        }

        Stack<Integer> st = new Stack<>();
        ListNode dummy = head;

        // Push all values onto the stack.
        while (dummy != null) {
            st.push(dummy.val);
            dummy = dummy.next;
        }

        // Traverse the list again and compare with stack values.
        dummy = head;
        while (dummy != null) {
            if (st.pop() != dummy.val) {
                return false; // Mismatch found, not a palindrome.
            }
            dummy = dummy.next;
        }

        return true;
    }
}