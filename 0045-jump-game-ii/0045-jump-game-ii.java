class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        int nextPoint = 0;
        int jumps = 0;
        int i =0;
        while(i<len){
            if(i>=len-1) return jumps;
            int maxDistancePossible = nums[i];
            if(i+maxDistancePossible>=len-1) return jumps+1;
            for(int  j = i+1; j<len && j<=i+nums[i]; j++){
                int possibleDistance = j-i+nums[j];
                if(maxDistancePossible <= possibleDistance){
                    maxDistancePossible = possibleDistance;
                    nextPoint = j;
                }
            }
            i = Math.min(nextPoint,len-1);
            jumps++;
            System.out.println(i+" "+jumps);
        }
        return jumps;
    }
}
