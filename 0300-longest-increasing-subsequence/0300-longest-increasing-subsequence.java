class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        Arrays.fill(dp, 1); // min length of LIS will be 1 at each index
        for(int curr = 0; curr< nums.length; curr++){
            for(int i=curr-1; i>=0; i--){
                if(nums[curr] > nums[i]){
                    dp[curr] = Math.max(dp[curr], 1+ dp[i]);
                }
            }
            max = Math.max(max , dp[curr]);
        }
        return max;
    }
}