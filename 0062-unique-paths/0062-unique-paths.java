class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return helper(0,0, m-1, n-1, dp);
    }
    private int helper(int i, int j, int m, int n, int[][] dp){
        if(i==m && j==n) return 1;
        if(i>m || j>n) return 0;
        if(dp[i][j] !=0) return dp[i][j];
        return dp[i][j] = helper(i+1, j, m, n, dp)+ helper(i, j+1, m, n, dp);
    }
}