class Solution {
    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        int count = 0;
        for(int i : nums){
            ans[count++] = nums[i];
        }
        return ans;
    }
}