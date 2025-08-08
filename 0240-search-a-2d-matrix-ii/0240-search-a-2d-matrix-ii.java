class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean bs = false;
        for(int[] arr : matrix){
            bs|=binarySearch(arr, target);
            if(bs) return true;
        }
        return false;
    }
    private boolean binarySearch(int[] arr, int target){
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]==target) return true;
            else if(arr[mid]>target) high = mid-1;
            else low = mid+1;
        }
        return false;
    }
}

