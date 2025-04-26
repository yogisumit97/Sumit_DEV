class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        int prev = -101;
        for(int i =0; i<nums.length;i++){
            if(nums[i]!=prev){
                nums[count++]= nums[i];
                prev = nums[i];
            }
        }
        return count;
    }
}