class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int i=0; i<prices.length; i++) dp[i][0] = dp[i][1] = -1;
        return helper(prices, 0, true, dp);
    }
    private int helper(int[] prices, int i, boolean canBuy, int[][] dp){
        if(i>=prices.length) return 0;
        int buy = 0;
        int skip = 0;
        int sell = 0;
        int j = canBuy==true? 1 : 0;
        if(dp[i][j] !=-1) return dp[i][j];
        if(canBuy){
            buy = -1*prices[i] + helper(prices, i+1, false, dp);
        }
        if(!canBuy){
            sell = prices[i] + helper(prices, i+1, true, dp);
        }
        skip = helper(prices, i+1, canBuy, dp);
        return dp[i][j] = Math.max(skip, Math.max(buy, sell));
    }
}