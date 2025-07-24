class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length+1];
        for(int i=0; i<nums.length; i++) Arrays.fill(dp[i], -1);
        return helper(nums, 0, -1, dp);
    }
    private int helper(int[] nums, int i, int prevIdx, int[][] dp){
        if(i>=nums.length) return 0;
        if(dp[i][prevIdx+1]!= -1) return dp[i][prevIdx+1];
        int take = 0;
        if(prevIdx==-1 || nums[i]>nums[prevIdx]) take = 1 + helper(nums, i+1, i, dp);
        int skip = helper(nums, i+1, prevIdx, dp);
        return dp[i][prevIdx+1]= Math.max(take, skip);
    }
}