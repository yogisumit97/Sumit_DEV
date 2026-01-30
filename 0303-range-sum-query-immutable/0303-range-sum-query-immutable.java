class NumArray {
    int arr[];
    int prefixSum[];
    public NumArray(int[] nums) {
        arr = new int[nums.length];
        prefixSum = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            arr[i] = nums[i];
            if(i==0) prefixSum[i] = arr[i];
            else prefixSum[i] = arr[i] + prefixSum[i-1];
        }
    }
    public int sumRange(int left, int right) {
        if(left ==0) return prefixSum[right];
        else return prefixSum[right] - prefixSum[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */