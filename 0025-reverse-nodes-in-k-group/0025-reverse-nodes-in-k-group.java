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
    private int len(ListNode head){
        ListNode dummy = head;
        int count= 0;
        while(dummy != null){
           count++;
           dummy = dummy.next;
        }
        return count;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return null;
        }
        if(len(head) < k){
            return head;
        }
    
            int count = 0;
            ListNode curr = head;
            ListNode prev = null;
            while(curr != null && count < k){
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
                count++;
            }
       head.next = reverseKGroup(curr,k);
            
    return prev;    
}
}