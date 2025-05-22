class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int len = matrix.length;
        int dp[] = new int[len];
        int minSum = Integer.MAX_VALUE;
        for(int i =0; i<len; i++){
            int[] temp = new int[len];
            for(int j=0; j<len; j++){
                if(i==0) temp[j] = matrix[i][j];
                else{
                    int dl = j-1>=0 ? dp[j-1] : Integer.MAX_VALUE;
                    int du = dp[j];
                    int dr = j+1 < len ? dp[j+1] : Integer.MAX_VALUE;
                    temp[j] = matrix[i][j] + Math.min(dl, Math.min(du, dr));
                }
            }
            dp = temp;
        }
        for(int i=0; i< len; i++){
            minSum = Math.min(minSum, dp[i]);
        }
        return minSum;
    }
}
