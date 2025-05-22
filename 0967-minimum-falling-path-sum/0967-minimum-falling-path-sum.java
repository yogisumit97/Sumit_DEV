class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int len = matrix.length;
        int dp[][] = new int[len][len];
        int minSum = Integer.MAX_VALUE;
        for(int i =0; i<len; i++){
            for(int j=0; j<len; j++){
                if(i==0) dp[i][j] = matrix[i][j];
                else{
                    int dl = j-1>=0 ? dp[i-1][j-1] : Integer.MAX_VALUE;
                    int du = dp[i-1][j];
                    int dr = j+1 < len ? dp[i-1][j+1] : Integer.MAX_VALUE;
                    dp[i][j] = matrix[i][j] + Math.min(dl, Math.min(du, dr));
                }
            }
        }
        for(int i=0; i< len; i++){
            minSum = Math.min(minSum, dp[len-1][i]);
        }
        return minSum;
    }
}
