class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        int[][][] dp = new int[len+1][2][k+1];
        for(int i=len-1; i>=0; i--){
            for(int j=0; j<2; j++){
                for(int cap=1; cap<=k; cap++){
                    int profit = 0;
                    if(j==1){
                        profit = Math.max(-1*prices[i]+ dp[i+1][0][cap], dp[i+1][1][cap]);// buy or skip
                    }
                    else{
                        profit = Math.max(prices[i]+ dp[i+1][1][cap-1], dp[i+1][0][cap]);// sell or skip
                    }
                    dp[i][j][cap] = profit;
                }
            }
        }
        return dp[0][1][k];
    }
}