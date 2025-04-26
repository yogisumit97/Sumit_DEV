class Solution {
    public int removeDuplicates(int[] nums) {
        int prev = Integer.MIN_VALUE;
        int count = 0;
        int set = 0;
        for(int i : nums){
            if(i!=prev || (i==prev && set<=1)){
                if(i!=prev) set=0;
                prev = i;
                nums[count++] = i;
                set++;
            }
        }
        return count;
    }
}