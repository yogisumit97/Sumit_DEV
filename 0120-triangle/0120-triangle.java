class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp.length; j++) dp[i][j] = Integer.MIN_VALUE;
        } 
        return minTotalHelper(0, 0, triangle, dp);
    }
    private int minTotalHelper(int i, int j, List<List<Integer>> t, int[][] dp){
        if(i==t.size()) return 0;
        if(dp[i][j] !=Integer.MIN_VALUE) return dp[i][j];
        return dp[i][j] = t.get(i).get(j) + Math.min(minTotalHelper(i+1, j, t, dp),minTotalHelper(i+1, j+1, t, dp));        
    }
}