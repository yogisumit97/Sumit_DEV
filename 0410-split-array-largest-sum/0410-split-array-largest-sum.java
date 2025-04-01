class Solution {
    public int splitArray(int[] nums, int k) {
        if(nums.length==1) return nums[0];
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int i : nums){
            low = Math.max(i,low);
            high+=i;
        }
        while(low <= high){
            int mid = (low+high)/2; // if this is max. sum of subarray then find how many subarrays can be
            int subarrays = 1;
            int sum = 0;
            for(int i : nums){
                if(i+sum> mid){
                    sum = i;
                    subarrays++;
                }
                else if(mid == sum+i){
                    sum = 0;
                    subarrays++;
                }
                else sum+=i;
            }
            if(sum==0) subarrays--;
            if(subarrays > k){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return low;
    }
}