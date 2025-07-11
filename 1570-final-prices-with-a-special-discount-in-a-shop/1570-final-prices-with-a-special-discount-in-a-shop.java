class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> st = new Stack<Integer>();
        for(int i = n - 1;i >= 0;i--){
            while(!st.isEmpty() && st.peek() > prices[i]){
                st.pop();
            }
                answer[i] = prices[i] - (st.isEmpty() ? 0 : st.peek());
           
            st.push(prices[i]);
        }
        return answer;
    }
}