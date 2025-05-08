class Solution {
    public int findMaxConsecutiveOnes(int[] nums) { //sliding window
        int l = 0;
        int max = 0;
        for(int r=0; r< nums.length; r++){
            if(nums[r]==1){
                max = Math.max(max, r-l+1);
            }
            else l = r+1;
        }
        return max;
    }
}