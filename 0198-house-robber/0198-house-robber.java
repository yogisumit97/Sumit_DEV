class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        Integer[] dp = new Integer[nums.length];
        return robHelper(nums, nums.length-1, dp);
    }
    private int robHelper(int[] nums, int i, Integer[] dp){
        if(i==0){
            return nums[0];
        }
        else if(i==1){
            return Math.max(nums[0], nums[1]);
        }
        if(dp[i]!=null) return dp[i];
        return dp[i] = Math.max(nums[i] + robHelper(nums, i-2, dp), robHelper(nums, i-1, dp));
    }
}