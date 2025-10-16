class Solution {
    public int findMin(int[] nums) {
        int min = 5001;
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int m = (l+r)/2;
            if(nums[m] >= nums[l]){
                min = Math.min(min, nums[l]);
                l = m+1;
            }
            else{
                min = Math.min(min, nums[m]);
                r = m-1;
            }
        }
        return min;
    }
}