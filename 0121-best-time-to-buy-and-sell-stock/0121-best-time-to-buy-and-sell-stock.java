class Solution {
    public int maxProfit(int[] prices) {
        int bought = Integer.MAX_VALUE;
        int profit = 0;
        for(int price : prices){
            if(price <= bought) bought = price;
            else{
                profit = Math.max(profit, price - bought);
            }
        }
        return profit;
    }
}