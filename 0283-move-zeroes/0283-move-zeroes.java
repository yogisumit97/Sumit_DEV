class Solution {
    public void moveZeroes(int[] nums) {
        int zeroPos = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0) continue;
            swap(nums, i, zeroPos);
            zeroPos++;
        }
    }
    private void swap(int[] arr,int i ,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}