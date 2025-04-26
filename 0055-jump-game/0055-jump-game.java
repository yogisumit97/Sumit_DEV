class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int maxDistanceIndex = 0;
        for(int i =0; i<len; i++){
            if(i>maxDistanceIndex) return false;
            maxDistanceIndex = Math.max(maxDistanceIndex, i+nums[i]);
            if(maxDistanceIndex>=len-1) return true;
        }
        return true;
    }
}