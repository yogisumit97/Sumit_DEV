class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lb = lowerBound(nums, target);
        int[] range = {-1,-1};
        if(nums.length==0) return range;
        if(lb<nums.length && nums[lb] == target) range[0] = lb;
        while(lb<nums.length && nums[lb] == target){
            range[1] = lb;
            lb++;
        }
        return range;
    }
    public int lowerBound(int[] nums, int x){
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int m = (l+r)/2;
            if(nums[m] < x) l = m+1;
            else r = m-1;
        }
        return l;
    }
}