class Solution {
    public boolean canJump(int[] nums) {
        int nextPoint = 0;
        int i =0;
        while(i<nums.length){
            int maxDistancePossible = nums[i];
            if(i+maxDistancePossible+1 >= nums.length) return true;
            for(int  j = i+1; j<nums.length && j<=i+nums[i]; j++){
                if(maxDistancePossible <= j-i+nums[j]){
                    maxDistancePossible = j-i+nums[j];
                    nextPoint = j;
                }
            }
            if(nextPoint!=nums.length-1 && nums[nextPoint]==0) return false;
            i = nextPoint;
        }
        return true;
    }
}