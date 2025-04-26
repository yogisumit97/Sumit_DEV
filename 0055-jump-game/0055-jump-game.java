class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int maxDistanceIndex = 0;
        for(int i =0; i<len; i++){
            maxDistanceIndex = Math.max(maxDistanceIndex, i+nums[i]);
            if(maxDistanceIndex == i && i!=len-1) return false;
            else if(maxDistanceIndex>=len-1) return true;
        }
        return true;
    }
}