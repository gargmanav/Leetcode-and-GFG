class Solution {
    public int lastRemaining(int n) {
        boolean left = true;
        int head = 1,step = 1;
        while(n > 1){
            if (left || (n % 2==1)) {
        head += step;
    }
            step *=2;
            n /=2;
            left = !left;
        }
        return head;
    }
}