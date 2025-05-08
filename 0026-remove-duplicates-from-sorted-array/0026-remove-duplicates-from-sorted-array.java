class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 1; //first element is already unique. 
        for(int i =1; i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                nums[count++]= nums[i];
            }
        }
        return count;
    }
}