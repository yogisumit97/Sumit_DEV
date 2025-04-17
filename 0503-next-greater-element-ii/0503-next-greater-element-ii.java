class Solution{
    public int[] nextGreaterElements(int[] nums){
        int[] result = new int[nums.length];
        int loopCounter = 0;
        while(loopCounter<nums.length){
            int res = -1;
            for(int i = (loopCounter+1)%nums.length; i!=loopCounter;i=(i+1)%nums.length){
                if(nums[i]>nums[loopCounter]){
                    res = nums[i];
                    break;
                }
            }
            result[loopCounter] = res; 
            loopCounter++;
        }
        return result;
    }
}

