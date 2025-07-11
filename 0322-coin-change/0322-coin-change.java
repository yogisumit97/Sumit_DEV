class Solution {
    public static final int INF = (int)1e8;
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[][] dp = new int[coins.length][amount+1];
        for(int i=0; i<coins.length; i++) dp[i][0] = 0;
        int count = 1;
        for (int amt = 1; amt <= amount; amt++) {
            if (amt % coins[0] == 0)
                dp[0][amt] = amt / coins[0];
            else
                dp[0][amt] = INF;
        }
        for(int i =1; i<coins.length; i++){
            for(int amt=0; amt<=amount; amt++){
                // take current 
                int take = INF;
                if(amt>=coins[i]) take = 1 + dp[i][amt-coins[i]];
                // not take current
                int notTake = dp[i-1][amt];
                dp[i][amt] = Math.min(take, notTake);
            }
        }
        return dp[coins.length-1][amount]==INF ? -1 : dp[coins.length-1][amount];
    }
}