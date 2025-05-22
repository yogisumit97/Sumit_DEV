class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[] dp = new int[len];
        for(int i=len-1; i>=0; i--){
            for(int j=0; j<=i; j++){
                if(i == len-1) dp[j] = triangle.get(i).get(j);
                else{
                    dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
                }
            }
        } 
        return dp[0];
    }
}