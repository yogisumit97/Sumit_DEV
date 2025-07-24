class Solution {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        for(int i=0; i<len; i++){
            dp[i][0] = dp[i][1] = -1;
        }
        return helper(prices, 0, 1, dp, fee);
    }
    private int helper(int[] prices, int i, int canBuy, int[][] dp, int fee){
        if(i>=prices.length) return 0;
        if(dp[i][canBuy]!=-1) return dp[i][canBuy];
        int profit = 0;
        if(canBuy==1){ // buy or skip
            profit = Math.max(-prices[i]+ helper(prices, i+1, 0, dp, fee), helper(prices, i+1, 1, dp, fee));
        }
        else{ // sell or skip
            profit = Math.max(prices[i]-fee+ helper(prices, i+1, 1, dp, fee), helper(prices, i+1, 0, dp, fee));// cooldown
        }
        return dp[i][canBuy] = profit;
    }
}