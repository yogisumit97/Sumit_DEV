class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = Integer.MAX_VALUE;
        for(int i : prices){
            if(i< buy) buy = i;
            else{
                profit = Math.max(profit, i-buy);
            }
        }
        return profit;
    }
}