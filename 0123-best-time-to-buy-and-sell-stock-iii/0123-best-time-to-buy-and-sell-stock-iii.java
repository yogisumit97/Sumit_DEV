class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][2];
        for(int i=0; i<prices.length; i++){
            for(int j=0; j<2; j++){
                for(int k=0; k<2; k++) dp[i][j][k] = -1;
            }
        }
        return helper(prices, 0, true, dp, 2);
    }
    private int helper(int[] prices, int i, boolean canBuy, int[][][] dp, int rem){
        if(i>=prices.length || rem==0) return 0;
        int buy = 0;
        int skip = 0;
        int sell = 0;
        int j = canBuy==true? 1 : 0;
        if(dp[i][j][rem-1] !=-1) return dp[i][j][rem-1];
        if(canBuy){
            buy = -1*prices[i] + helper(prices, i+1, false, dp, rem);
        }
        if(!canBuy){
            sell = prices[i] + helper(prices, i+1, true, dp, rem-1);
        }
        skip = helper(prices, i+1, canBuy, dp, rem);
        return dp[i][j][rem-1] = Math.max(skip, Math.max(buy, sell));
    }
}