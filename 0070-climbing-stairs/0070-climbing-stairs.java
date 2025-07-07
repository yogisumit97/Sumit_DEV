class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        for(int i=0; i<n+1; i++) dp[i] = -1;
        return climbStairsHelper(n, 0, dp);
    }
    private int climbStairsHelper(int n, int curr, int[] dp){
        if(curr==n) return 1; // reached
        if(curr>n) return 0;
        if(dp[curr]!=-1) return dp[curr];
        return dp[curr] = climbStairsHelper(n, curr+1, dp)+climbStairsHelper(n, curr+2, dp); 
    }
}