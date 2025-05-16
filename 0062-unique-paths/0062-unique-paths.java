class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int i =0; i<m+1; i++){
            for(int j=0; j<n+1; j++) dp[i][j] = -1;
        }
        return uniquePathHelper(0,0,m,n, dp);
    }
    private int uniquePathHelper(int i, int j, int m, int n, int[][] dp){
        if(i>=m || j>=n) return 0;
        if(i== m-1 && j==n-1) return 1;
        if(dp[i][j+1] == -1){
            dp[i][j+1] = uniquePathHelper(i, j+1, m, n, dp); // move right 
        }
        if(dp[i+1][j] == -1){
            dp[i+1][j] = uniquePathHelper(i+1, j, m, n, dp); // move down
        }
        return dp[i][j+1] + dp[i+1][j];
    }
}