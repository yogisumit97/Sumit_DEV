class Solution {
    public int rob(int[] nums) {
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            dp1[i] = dp2[i] = -1;
        }
        int excludingFirst = robHelper(1,nums.length-1, nums, dp1);
        int excludingLast = robHelper(0,nums.length-2, nums, dp2);
        return Math.max(excludingFirst, excludingLast);
    }
    private int robHelper(int i, int j, int[] nums, int[] dp){
        if(nums.length==1) return nums[0];
        if(j==i) return nums[i];
        if(j==i+1) return Math.max(nums[i+1], nums[i]);
        if(dp[j]!=-1) return dp[j];
        return dp[j] = Math.max(robHelper(i,j-1, nums, dp), nums[j] + robHelper(i,j-2, nums, dp));
    }
}