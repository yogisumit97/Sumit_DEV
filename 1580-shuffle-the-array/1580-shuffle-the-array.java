class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] arr = new int[2*n];
        int count = 0;
        for(int i=0; i<n; i++){
            arr[count] = nums[i];
            count = count+2;
        }
        count = 1;
        for(int i=n; i<2*n; i++){
            arr[count] = nums[i];
            count = count+2;
        }
        return arr;
    }
}