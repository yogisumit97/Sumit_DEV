class Solution {
    public void sortColors(int[] nums) {
        // assumption 0 to low-1 all 0, low to mid-1 all 1, high+1 to n all 2
        // so mid  to high are all random numbers
        int low = 0;
        int mid = 0;
        int high = nums.length-1;
        while(mid<=high){
            switch(nums[mid]){
                case 0 :
                    swap(nums, low, mid);
                    low++;
                    mid++;
                    break;
                case 1 :
                    mid++;
                    break;
                case 2 :
                    swap(nums, mid, high);
                    high--;
                    break;
            }
        }    
    }
    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
