class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[][] dp = new int[len][len];
        for(int i=len-1; i>=0; i--){
            for(int j=i; j>=0; j--){
                if(i == len-1) dp[i][j] = triangle.get(i).get(j);
                else{
                    dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
                }
            }
        } 
        return dp[0][0];
    }
}