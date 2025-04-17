class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] max = new int[nums2.length];
        int count = nums2.length-1;
        while(count>=0){
            int res = -1;
            for(int i = count+1; i<nums2.length;i++){
                if(nums2[i]>nums2[count]){
                    res = nums2[i];
                    break;
                }
            }
            max[count] = res; 
            count--;
        }
        int[] ans = new int[nums1.length];
        for(int i =0; i<nums2.length; i++){
            for(int j=0; j<nums1.length; j++){
                if(nums1[j]==nums2[i]){
                    ans[j]=max[i];
                }
            }
        }
        return ans;
    }
}
