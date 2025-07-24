class Solution {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        int[][] dp = new int[len+1][2];
        for(int i=len-1; i>=0; i--){
            for(int j=0; j<2; j++){
                int profit = 0;
                if(j==1){ // buy or skip
                    profit = Math.max(-prices[i]+ dp[i+1][0], dp[i+1][1]);
                }
                else{ // sell or skip
                    profit = Math.max(prices[i]-fee+ dp[i+1][1], dp[i+1][0]);// cooldown
                }
                dp[i][j] = profit;
            }
        }
        return dp[0][1];
    }
    private int helper(int[] prices, int i, int canBuy, int[][] dp){
        if(i>=prices.length) return 0;
        if(dp[i][canBuy]!=-1) return dp[i][canBuy];
        int profit = 0;
        if(canBuy==1){ // buy or skip
            profit = Math.max(-prices[i]+ helper(prices, i+1, 0, dp), helper(prices, i+1, 1, dp));
        }
        else{ // sell or skip
            profit = Math.max(prices[i]+ helper(prices, i+2, 1, dp), helper(prices, i+1, 0, dp));// cooldown
        }
        return dp[i][canBuy] = profit;
    }
}