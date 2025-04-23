class Solution {
    public int longestOnes(int[] nums, int k) {// find longest subarray with atmost k zeros
        int l =0;
        int r = 0;
        int count = k;
        int maxLen = -1;
        while(r< nums.length){
            if(nums[r]==0 && count==0){
                while(nums[l]!=0) l++;
                l++;
            }
            else if(nums[r]==0) count--;
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        return maxLen;
    }
}