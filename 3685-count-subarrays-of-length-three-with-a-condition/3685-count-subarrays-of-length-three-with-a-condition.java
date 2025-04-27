class Solution {
    public int countSubarrays(int[] arr) {
        if(arr.length<=2) return 0;
        int count = 0;
        for(int i =2; i<arr.length; i++){
            if((double)(arr[i]+arr[i-2]) == arr[i-1]*1.0/2) count+=1;
        }
        return count;
    }
}