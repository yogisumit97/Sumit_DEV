class Solution { // tabulation method > no recursion stack space in space complexity
    public int[] dp = new int[31];
    public int fib(int n) {
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<n+1; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}