class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i=0; i<dp.length; i++) dp[i] = -1;
        return robHelper(nums.length-1, nums, dp);
    }
    private int robHelper(int i, int[] nums, int[] dp){
        if(i==0) return nums[i];
        if(i==1) return Math.max(nums[1], nums[0]);
        if(dp[i]!=-1) return dp[i];
        return dp[i] = Math.max(robHelper(i-1, nums, dp), nums[i] + robHelper(i-2, nums, dp));
    }
}