class Solution { // space optimization 
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        for(int i = m-1; i>=0; i--){
            for(int j = n-1; j>=0; j--){
                if(i==m-1 && j==n-1){
                    dp[n-1] = 1;
                    continue;
                }
                int right = j+1< n ? dp[j+1] : 0; // right
                dp[j]+=right;
            }
        }
        return dp[0];
    }
}