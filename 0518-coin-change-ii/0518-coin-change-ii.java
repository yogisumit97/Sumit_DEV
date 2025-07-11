class Solution {
    public int change(int amount, int[] coins) {
        Integer[][] dp = new Integer[coins.length][amount+1];
        return helper(coins, coins.length-1, amount, dp);
    }
    private int helper(int[] coins, int i, int amt, Integer[][] dp){
        if(i<0 || amt<=0){
            if(amt==0) return 1;
            return 0;
        }
        if(dp[i][amt]!=null) return dp[i][amt];
        int take = helper(coins, i, amt-coins[i], dp);
        int notTake = helper(coins, i-1, amt, dp);
        return dp[i][amt] = take+notTake;
    }
}