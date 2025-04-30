class Solution {
    public int[] productExceptSelf(int[] nums) {
        int productWithoutZeroes = 1;
        int len = nums.length;
        int zeroCount = len;
        int zeroIndex = -1;
        for(int i = 0; i<len; i++){
            if(nums[i] !=0){
                productWithoutZeroes*=nums[i];
                zeroCount--;
            }
            else zeroIndex = i;
        }
        int[] arr = new int[len]; 
        if(zeroCount==1){
            arr[zeroIndex] = productWithoutZeroes;
        }
        else if(zeroCount==0){
            for(int i=0; i<len; i++){
                arr[i] = productWithoutZeroes/nums[i];
            }
        }
        return arr;
    }
}