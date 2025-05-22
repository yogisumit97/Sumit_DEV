class Solution {
    public int uniquePathsWithObstacles(int[][] og) {
        int m = og[0].length;
        int n = og.length;
        int[] dp = new int[m];
        for(int i =0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i==0 && j==0){
                    if(og[i][j]==1) return 0;
                    dp[j] = 1;
                }
                else if(og[i][j] == 1){
                    dp[j] = 0;
                }
                else{
                    int left = j-1>=0 ? dp[j-1] : 0;
                    dp[j]+= left;
                }
            }
        }
        return dp[m-1];
    }    
}