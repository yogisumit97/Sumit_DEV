class Solution {
    public int[] singleNumber(int[] nums) {
        int size = nums.length;
        // using concept of buckets.
        int xor = 0;
        for(int i : nums) xor^=i;
        xor = (xor&(xor-1))^(xor);  // to get msb from right
        // now base on xor & and form buckets.
        int[] bucket = new int[size];
        for(int i =0; i<size; i++){
            bucket[i] = xor&nums[i];  // either bucket will be 0 or some same no. corresponding to bit
        }
        int num1 = 0;
        int num2 =0;    
        for(int i=0; i<size; i++){
            if(bucket[i]==0) num1^=nums[i];
            else num2^=nums[i];
        }
        return new int[] {num1, num2};
    }
}