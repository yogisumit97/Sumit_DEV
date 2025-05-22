class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] dp  = new int[m+1];
        for(int j=m; j>=0; j--) dp[j] = Integer.MAX_VALUE;
        for(int i =n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                if(i==n-1 && j==m-1) dp[j] = grid[i][j];
                else dp[j] = grid[i][j] + Math.min(dp[j], dp[j+1]);
            }
        }
        return dp[0];
    }
}