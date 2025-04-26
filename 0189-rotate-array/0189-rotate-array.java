class Solution {
    public void reverseArray(int[] arr, int left, int right){
        while(left<right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k%len;
        reverseArray(nums,0, len-1);
        reverseArray(nums, 0, k-1);
        reverseArray(nums, k, len-1);
    }
}