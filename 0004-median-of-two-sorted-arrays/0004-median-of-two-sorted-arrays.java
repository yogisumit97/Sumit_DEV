class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //question states logaserithmic time complexity thus binary search
         int n1 = nums1.length;
         int n2 = nums2.length;
         // it makes sense to apply BS on smaller array thus
         if(n2<n1) return findMedianSortedArrays(nums2,nums1); // now always first array will be smaller
         int low = 0;
         int high = n1;
         int n = n1+n2; //total size to check even odd in the end
         while(low<=high){
            int mid1= (low+high+1)/2; //if this many elements from smaller array or nums1
            int mid2= (n1+n2+1)/2 - mid1; // elements from nums2 = total elements/2 - ele. taken from nums1
            int l1 = Integer.MIN_VALUE; 
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            if(mid1<n1) r1 = nums1[mid1];
            if(mid2<n2) r2 = nums2[mid2];
            if(mid1-1>=0) l1= nums1[mid1-1];
            if(mid2-1>=0) l2= nums2[mid2-1];
            if(l1<=r2 && l2<=r1){ //cross checks only as arrays are sorted
                //check even off and return accly.
                //System.out.println(l1+" "+r1+" "+l2+" "+r2);
                if(n%2==0){
                    return ((double) Math.max(l1, l2) + (double) Math.min(r1, r2)) / 2.0;
                }
                else return (double)Math.max(l1,l2);
            }
            else if(r1<l2) low=mid1+1;
            else high = mid1-1;
         }
         return 0;
    }
}