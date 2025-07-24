class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][][] dp = new int[len+1][2][3];
        for(int i=0;i<len; i++){
            for(int j =0; j<2; j++){
                dp[i][j][0] = 0; // cap = 0 base case
            }
        }
        for(int j=0;j<2; j++){
            for(int k =0; k<3; k++){
                dp[len][j][k] = 0; // day=len base case
            }
        }

        for(int i=len-1;i>=0; i--){
            for(int j =0; j<2; j++){
                for(int k=0; k<3; k++){
                    int profit = 0;
                    if(j==1){
                        profit = Math.max(-1*prices[i]+ dp[i+1][0][k], dp[i+1][1][k]); // buy or skip
                    }
                    else{
                        if(k>0) profit = Math.max(prices[i]+ dp[i+1][1][k-1], dp[i+1][0][k]); // sell or skip
                    }
                    dp[i][j][k] = profit;
                }
            }
        }
        return dp[0][1][2];
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