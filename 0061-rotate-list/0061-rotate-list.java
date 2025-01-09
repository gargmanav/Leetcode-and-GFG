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
        int count = 0;
        ListNode temp = head;
        while(temp != null){
            count++;
            temp = temp.next; 
        }
        return count;
    }
    
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0)return head;
        int count = len(head);
        k = k % count;
        if(k == 0)return head;
        ListNode tail = head;
        for(int i = 1;i<count - k;i++){
            tail = tail.next;
        }
        ListNode newNode = tail.next;
         ListNode res = tail.next;
        tail.next = null;
        
       
        while(newNode.next != null){
            newNode = newNode.next;
        }
        newNode.next = head;
        return res;
    }
}