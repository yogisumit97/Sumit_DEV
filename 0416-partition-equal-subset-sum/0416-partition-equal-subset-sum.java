class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int len = nums.length;
        for(int i : nums) sum+= i;
        if(sum%2!=0) return false;
        sum=sum/2;
        boolean[] dp = new boolean[sum+1];
        for(int i=0; i<len; i++) dp[0] = true;
        if(nums[0] <= sum) dp[nums[0]] = true;
        for(int i=1; i<len; i++){
            boolean[] temp = new boolean[sum+1];
            temp[0] = true;
            for(int j=1; j<sum+1; j++){
                boolean notTake = dp[j];
                boolean take = false;
                if(j - nums[i] >=0) take = dp[j-nums[i]];
                temp[j] = take|notTake;
            }
            for(int j =0; j<sum+1; j++){
                dp[j] = temp[j];
            }
        }
        return dp[sum];
    }
}