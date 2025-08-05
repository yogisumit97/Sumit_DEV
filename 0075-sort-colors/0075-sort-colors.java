class Solution {
    public void sortColors(int[] nums) {
        // brute force.
        int one= 0;
        int two= 0;
        int zero = 0;
        for(int i : nums){
            if(i==0) zero++;
            else if(i==1) one++;
            else two++;
        }
        int i=0;
        while(zero!=0){
            nums[i++] = 0;
            zero--;
        }
        while(one!=0){
            nums[i++] = 1;
            one--;
        }
        while(two!=0){
            nums[i++] = 2;
            two--;
        }
    }
}