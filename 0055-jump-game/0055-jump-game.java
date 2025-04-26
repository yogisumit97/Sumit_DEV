class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int nextPoint = 0;
        int i =0;
        while(i<len){
            int maxDistancePossible = nums[i];
            if(maxDistancePossible+i+1 >= len) return true;
            for(int  j = i+1; j<len && j<=i+nums[i]; j++){
                int possibleDistance = j-i+nums[j];
                if(maxDistancePossible <= possibleDistance){
                    maxDistancePossible = possibleDistance;
                    nextPoint = j;
                }
            }
            if(nums[nextPoint]==0 && nextPoint!=len-1) return false;
            i = nextPoint;
        }
        return true;
    }
}