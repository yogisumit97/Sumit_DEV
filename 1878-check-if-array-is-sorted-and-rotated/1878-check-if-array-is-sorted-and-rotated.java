class Solution {
    public boolean check(int[] nums) {
        int i =0;
        for(i=0; i<nums.length-1; i++){
            if(nums[i] > nums[i+1]) break;
        }
        for(int j=(i+1)%nums.length; j!=i; j=(j+1)%nums.length){
            if(nums[(j+1)%nums.length] < nums[j]) return false;
        }
        return true;
    }
}