class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, target, 0, 0);
    }
    private int helper(int[] nums, int tar, int i, int sum){
        if(i>=nums.length){
            if(tar==sum) return 1;
            else return 0;
        }
        return helper(nums, tar, i+1, sum+1*nums[i])+ helper(nums, tar, i+1, sum+(-1)*nums[i]);
    }
}