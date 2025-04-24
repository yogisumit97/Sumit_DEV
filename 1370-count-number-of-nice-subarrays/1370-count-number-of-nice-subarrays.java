class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return findSubArrayHelper(nums,k)-findSubArrayHelper(nums,k-1);
    }
    private int findSubArrayHelper(int[] nums,int goal){ // find subarrays with less or equal odd than goal
        if(goal<0) return 0;
        int l = 0;
        int r = 0;
        int count = 0;
        int odd = 0;
        while(r<nums.length){
            if((nums[r]&1) !=0) odd = odd+1;
            while(odd>goal){
                if((nums[l]&1) !=0) odd = odd-1;
                l=l+1;
            }
            count+=r-l+1; //increase count by len >> subarraysEnding here.
            r++;
        }
        //System.out.println(count);
        return count;
    }
}