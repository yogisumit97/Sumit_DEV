import java.util.*;
class Solution {
    public void nextPermutation(int[] nums) {
        // go for longer prefix match by finding breakpoint
        int i = nums.length-2;
        while(i>=0){
            if(nums[i]<nums[i+1]) break;
            i--;
        }
        if(i==-1){
            i = 0;
            int j = nums.length-1;
            while(i<j){
                swap(nums, i, j);
                i++;
                j--;
            }
            return;
        }
        // now i is the element for which ceil is needed in its right subarray
        // find ceil of breakpoint 
        int j = nums.length-1;
        while(j>i){
            if(nums[j] > nums[i]) break;
            j--;
        }
        // now j is just bigger and we have to replace it
        swap(nums, i, j);
        // rearrange remaining in sorted order
        i = i+1;
        j = nums.length-1;
        while(i<j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}