class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] next = new int[nums.length+1];
        int[] curr = new int[nums.length+1];
        for(int i= nums.length-1; i>=0; i--){
            for(int prevIdx=nums.length; prevIdx>=0; prevIdx--){
                int take = 0;
                int skip = 0;
                if(prevIdx==nums.length || nums[i]>nums[prevIdx]) take = 1 + curr[i];
                skip = 0 + curr[prevIdx];
                next[prevIdx] = Math.max(take, skip);
            }
            for(int j=0; j<=nums.length; j++) curr[j] = next[j];
        }
        return curr[nums.length];
    }
}