class Solution {
    public boolean check(int[] nums) { // one pass solution 
        int exception = 0;
        int i = 0;
        for(i=0; i<nums.length-1; i++){
            if(nums[i] > nums[i+1]) exception++;
        }
        if(nums[i] > nums[0]) exception++;
        if(exception>=2) return false; 
        return true;
    }
}