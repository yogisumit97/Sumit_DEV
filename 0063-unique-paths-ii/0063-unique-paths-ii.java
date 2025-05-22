class Solution {
    public int uniquePathsWithObstacles(int[][] og) {
        int m = og[0].length;
        int n = og.length;
        int[][] dp = new int[n][m];
        for(int i =0; i<n; i++){
            for(int j=0; j<m; j++) dp[i][j] = -1;
        }
        return helper(n-1, m-1, og, dp);
    }
    private int helper(int i, int j, int[][] og, int[][] dp){
        if(i<0 || j<0 || og[i][j] ==1) return 0;
        if(i ==0 && j==0) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        return dp[i][j] = helper(i-1, j, og, dp) + helper(i, j-1, og, dp);// up + left
    }
}