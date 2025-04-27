class Solution {
    public boolean canJump(int[] nums) {
        int maxReachable = 0;
        int len = nums.length;
        for(int i=0; i<len; i++){
            if(i>maxReachable) return false;
            maxReachable = Math.max(maxReachable,i+nums[i]);
            if(maxReachable >=len-1) return true;
        }
        return true;
    }
}