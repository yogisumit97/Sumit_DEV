class Solution {
    public int majorityElement(int[] nums) {
        int maxOccurElement = nums[0];
        int occurance = 1;
        for(int i =1; i<nums.length; i++){
            if(nums[i]==maxOccurElement) occurance++;
            else occurance--;
            if(occurance ==0){
                occurance = 1;
                maxOccurElement = nums[i];
            }
        }
        return maxOccurElement;
    }
}