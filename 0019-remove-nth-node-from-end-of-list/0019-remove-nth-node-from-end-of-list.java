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
    public ListNode removeNthFromEnd(ListNode head, int n) {
       int count = 0;
       ListNode current = head;
       while(current != null){
         count++;
         current = current.next;
       }
       int steps = count - n;
       if(steps == 0)
         return head.next;
       current = head;
       for(int i = 1;i<steps;i++)
         current = current.next;
         current.next = current.next.next;
       
       return head;
    }
}