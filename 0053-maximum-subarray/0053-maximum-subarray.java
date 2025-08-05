class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int maxTillNow = 0;
        for(int i=0; i<nums.length; i++){
            maxTillNow = Math.max(nums[i], maxTillNow+nums[i]);
            max = Math.max(max, maxTillNow);
        }
        return max;
    }
}