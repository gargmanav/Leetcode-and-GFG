class Solution {
    public int maxProfit(int[] prices) {
        int min_price = Integer.MAX_VALUE;
        int max_price = 0;
        for(int price : prices){
            min_price = Math.min(min_price,price);
            max_price = Math.max(max_price,price - min_price);
        }
        return max_price;
    }
}