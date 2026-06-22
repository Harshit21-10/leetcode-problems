class Solution {
    public int maxProfit(int[] prices) {
        int max_profit = 0;
        int min_value = Integer.MAX_VALUE;
        for(int price : prices){
            min_value = Math.min(price, min_value);
            max_profit = Math.max(max_profit,price-min_value);
        }
        return max_profit;
        
    }
}