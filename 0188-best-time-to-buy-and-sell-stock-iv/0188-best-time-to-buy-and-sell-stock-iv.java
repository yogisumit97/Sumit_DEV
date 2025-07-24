class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        int[][][] dp = new int[len][2][k+1];
        for(int i=0; i<len; i++){
            for(int j=0; j<2; j++){
                for(int p=0; p<=k; p++){
                    dp[i][j][p] = -1;
                }
            }
        }
        return helper(prices, 0, 1, k, dp);
    }
    private int helper(int[] prices, int day, int canBuy, int cap, int[][][] dp){
        if(day>=prices.length || cap==0){
            return 0;
        }
        if(dp[day][canBuy][cap]!=-1) return dp[day][canBuy][cap]; 
        int profit = 0;
        if(canBuy==1){
            profit = Math.max(-1*prices[day]+ helper(prices, day+1, 0, cap, dp), helper(prices, day+1, 1, cap, dp)); // buy or skip
        }
        else{
            profit = Math.max(prices[day]+ helper(prices, day+1, 1, cap-1, dp), helper(prices, day+1, 0, cap, dp)); // sell or skip
        }
        return dp[day][canBuy][cap] = profit;
    }
}