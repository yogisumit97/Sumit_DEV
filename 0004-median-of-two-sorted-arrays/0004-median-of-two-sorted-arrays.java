class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int arr[] = new int[nums1.length+nums2.length];
        int len = nums1.length+nums2.length;
        int index = 0; 
        int i =0;
        int j =0;
        double ans =0;
        while(!(i== nums1.length && j==nums2.length)){
            if(j==nums2.length){
                arr[index++] = nums1[i++];
            }
            else if(i==nums1.length){
                arr[index++] = nums2[j++];
            }
            else{
                if(nums1[i] <= nums2[j]){
                    arr[index++] = nums1[i++];
                }
                else{
                    arr[index++] = nums2[j++];
                }
            }
        }
        for(int k : arr) System.out.print(k+" ");
        if(len%2 ==0){
            len = (len-1)/2;
            ans = ((double)arr[len] +arr[len+1])/2;
        }
        else{
            len = (len-1)/2;
            ans = (double)arr[len];
        }
        return ans;
    }
}