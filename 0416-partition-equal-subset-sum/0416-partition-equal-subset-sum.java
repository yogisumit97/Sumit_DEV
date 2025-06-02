class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int len = nums.length;
        for(int i : nums) sum+= i;
        if(sum%2!=0) return false;
        sum=sum/2;
        boolean[][] dp = new boolean[len][sum+1];
        for(int i=0; i<len; i++) dp[i][0] = true;
        if(nums[0] <= sum) dp[0][nums[0]] = true;
        for(int i=1; i<len; i++){
            for(int j=1; j<sum+1; j++){
                boolean notTake = dp[i-1][j];
                boolean take = false;
                if(j - nums[i] >=0) take = dp[i-1][j-nums[i]];
                dp[i][j] = take|notTake;
            }
        }
        return dp[len-1][sum];
    }
}