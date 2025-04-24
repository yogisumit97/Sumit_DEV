class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return findSubArrayHelper(nums,goal)-findSubArrayHelper(nums,goal-1);
    }
    private int findSubArrayHelper(int[] nums,int goal){ // find subarray sum less than or equal to goal
        if(goal<0) return 0;
        int l = 0;
        int r = 0;
        int count = 0;
        int sum = 0;
        while(r<nums.length){
            sum+= nums[r];
            while(sum>goal){
                sum = sum-nums[l];
                l=l+1;
            }
            count+=r-l+1; //increase count by len >> subarraysEnding here.
            r++;
        }
        return count;
    }
}