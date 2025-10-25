class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int m = (l+r)/2;
            int first = 0;
            if(m>0 && nums[m-1] == nums[m]) first = m-1;
            else if(m<nums.length-1 && nums[m] == nums[m+1]) first = m;
            else return nums[m];
            if(first%2==0){
                l = m+1;
            }
            else{
                r = first-1;
            }
        }
        return -1;
    }
}