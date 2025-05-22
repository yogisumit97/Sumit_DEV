class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp  = new int[grid.length][grid[0].length];
        return pathSumHelper(grid, grid.length-1, grid[0].length-1, dp);
    }
    private int pathSumHelper(int[][] grid, int i, int j, int[][] dp){
        if(i==0 && j==0){
            return grid[i][j];
        }
        if(i<0 || j<0) return 40000; // max value possible returned for invalid case.
        if(dp[i][j] !=0) return dp[i][j];
        int up = pathSumHelper(grid, i-1, j, dp);
        int left = pathSumHelper(grid, i, j-1, dp);
        return dp[i][j] = grid[i][j] + Math.min(up, left);
    }
}