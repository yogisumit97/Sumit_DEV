class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int max =1;
        int i = 0;
        int count = 1;
        int j = 1;
        int curr = 0;
        while(i<nums.length && j< nums.length){
            curr+= (nums[j] - nums[j-1])*(j-i);
            if(curr<0){
                curr=0;
                j++;
                i++;
                continue;
            }
            if(curr <= k){
                count++;
                max = Math.max(max, count); 
                j++;
            }
            else{
                curr-= (nums[j]-nums[i]);
                i++; 
                j++;
            }
        }
        return max;
    }
}