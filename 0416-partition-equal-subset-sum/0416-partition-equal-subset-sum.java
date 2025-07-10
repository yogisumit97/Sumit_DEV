class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0; i<nums.length; i++) sum+= nums[i];
        if(sum%2!=0) return false;
        else sum = sum/2;
        Boolean[][] dp = new Boolean[nums.length][sum+1];
        return helper(nums, nums.length-1, sum, dp);
    }
    private boolean helper(int[] arr, int i, int sum, Boolean[][] dp){
        if(i==0) return sum==arr[i];
        if(sum==0 || arr[i] == sum) return dp[i][sum] = true;
        if(dp[i][sum]!=null) return dp[i][sum];
        boolean take = false;
        if(arr[i]<=sum) take = helper(arr, i-1, sum-arr[i], dp);
        if(take) return dp[i][sum] = true;
        boolean notTake = helper(arr, i-1, sum, dp);
        return dp[i][sum] = take|notTake;
    }
}