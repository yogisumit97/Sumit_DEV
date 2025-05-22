class Solution {
    public int uniquePathsWithObstacles(int[][] og) {
        int m = og[0].length;
        int n = og.length;
        int[][] dp = new int[n][m];
        for(int i =0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i==0 && j==0){
                    if(og[i][j]==1) return 0;
                    dp[i][j] = 1;
                }
                else if(og[i][j] == 1){
                    dp[i][j] = 0;
                }
                else{
                    int left = j-1>=0 ? dp[i][j-1] : 0;
                    int up = i-1>=0 ? dp[i-1][j] : 0;
                    dp[i][j] = left + up;
                }
            }
        }
        return dp[n-1][m-1];
    }    
}