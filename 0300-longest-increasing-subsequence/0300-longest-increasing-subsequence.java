class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length+1][nums.length+1];
        return helper(nums, 0, nums.length, dp);
    }
    private int helper(int[] nums, int i, int prevIdx, int[][] dp){
        if(i>=nums.length) return 0;
        if(dp[i][prevIdx] !=0) return dp[i][prevIdx];
        int take = 0;
        int skip = 0;
        if(prevIdx==nums.length || nums[i]>nums[prevIdx]) take = 1 + helper(nums, i+1, i, dp);
        skip = 0 + helper(nums, i+1, prevIdx, dp);
        return dp[i][prevIdx] = Math.max(take, skip);
    }
}