class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid]==target) return mid;
            //find sorted half
            if(nums[l] <= nums[mid]){ // left half sorted
                if(nums[l] > target || nums[mid] < target){
                    l = mid+1;
                }
                else{
                    r = mid-1;
                }
            }
            else{ //right half sorted
                if(nums[mid] > target || nums[r] < target){
                    r = mid-1;
                }
                else{
                    l = mid+1;
                }
            }
        }
        return -1;
    }
}