class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int sum1 = 0;
        int sum2 = 0;
        for(int i : nums) sum+= i;
        if(sum%2!=0) return false;
        sum1 = sum2 = sum/2;
        int[][] dp = new int[nums.length][sum1+1];
        for(int i =0; i<nums.length; i++){
            for(int j=0; j<sum1+1; j++) dp[i][j] = -1;
        }
        return helper(nums, sum1, nums.length-1, dp);
    }
    private boolean helper(int[] nums, int sum, int i, int[][] dp){
        if(i == 0){
            return sum == nums[i];
        }
        if(sum<0) return false;
        if(dp[i][sum]!=-1) return dp[i][sum]==1 ? true : false;
        boolean notTake = helper(nums, sum, i-1, dp);
        boolean take = false;
        if(sum - nums[i] >=0) take = helper(nums, sum-nums[i], i-1, dp);
        dp[i][sum] = take|notTake ? 1 : 0;
        return take | notTake;
    }
}