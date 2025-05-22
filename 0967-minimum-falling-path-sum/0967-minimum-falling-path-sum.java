class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int len = matrix.length;
        int dp[][] = new int[len][len];
        int minSum = Integer.MAX_VALUE;
        for(int i =0; i<len; i++){
            for(int j=0; j<len; j++){
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        for(int i=0; i< len; i++){
            minSum = Math.min(minSum, minSumHelper(0, i, matrix, dp));
        }
        return minSum;
    }
    private int minSumHelper(int i, int j, int[][] matrix, int[][] dp){
        if(i==matrix.length-1) return matrix[i][j];
        if(dp[i][j] !=Integer.MIN_VALUE) return dp[i][j];
        int dl = j-1>=0 ? minSumHelper(i+1, j-1, matrix, dp) : Integer.MAX_VALUE;
        int db = minSumHelper(i+1, j, matrix, dp);
        int dr = j+1 < matrix.length ? minSumHelper(i+1, j+1, matrix, dp) : Integer.MAX_VALUE;
        return dp[i][j] = matrix[i][j] + Math.min(dl, Math.min(db, dr));
    }
}
