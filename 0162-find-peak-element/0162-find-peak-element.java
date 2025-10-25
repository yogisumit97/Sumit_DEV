class Solution {
    public int findPeakElement(int[] nums) {
        int l =0;
        int r = nums.length -1;
        if(l==r) return 0;
        while(l<=r){
            int m = (l+r)/2;
            if((nums.length>1 && m==0 && nums[m]>nums[m+1]) || (nums.length>1 && m==nums.length-1 && nums[m]>nums[m-1])) return m;
            if(m!=0 && nums[m] < nums[m-1]) r = m-1;
            else if(m!=nums.length-1 && nums[m] < nums[m+1]) l = m+1;
            else return m;
        }
        return -1;
    }
}