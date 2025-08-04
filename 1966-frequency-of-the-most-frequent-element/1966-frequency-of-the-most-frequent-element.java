class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int j = 1;
        long cost = 0;
        int max = nums.length>1 ? 0 : 1;
        while(j<nums.length){
            cost+= (long)(nums[j]-nums[j-1])*(j-i); 
            while(i < nums.length && cost>k){
                    cost-= (long)(nums[j]-nums[i]);
                    i++;
            }
            j++;
            max = Math.max(j-i, max);
            //System.out.println("i:"+i+" ,j="+j+", cost="+cost+" ,max="+max);
        }
        return max;
    }
}