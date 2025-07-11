class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[][] dp = new int[coins.length][amount+1];
        int result = helper(coins, amount, coins.length-1, dp);
        return result==1e8 ? -1 : result;
    }
    private int helper(int[] coins, int amt, int i, int[][] dp){
        if(i<0 || amt<0) return (int)1e8;
        if(amt==0) return 0;
        if(dp[i][amt]!=0) return dp[i][amt];
        // take current 
        int take = 1 + helper(coins, amt-coins[i], i, dp);
        // not take current
        int notTake = helper(coins, amt, i-1, dp);
        return dp[i][amt] = Math.min(take, notTake);
    }
}