import java.util.Random;

class Solution {
    private ListNode head;
    private Random rand;

    public Solution(ListNode head) {
        this.head = head;
        this.rand = new Random();
    }

    public int getRandom() {
        int result = head.val;
        ListNode current = head.next;
        int index = 2;

        while (current != null) {
            // With probability 1/index, replace the result
            if (rand.nextInt(index) == 0) {
                result = current.val;
            }
            current = current.next;
            index++;
        }

        return result;
    }
}
