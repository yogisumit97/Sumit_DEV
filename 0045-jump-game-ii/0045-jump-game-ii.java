class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        int nextPoint = 0;
        int jumps = 0;
        int i =0;
        while(i<len){
            int maxDistancePossible = nums[i];
            if(i==len-1) return jumps; //reached
            else if(maxDistancePossible+i+1 >= len) return jumps+1; //next step reach
            for(int  j = i+1; j<len && j<=i+nums[i]; j++){
                int possibleDistance = j-i+nums[j];
                if(maxDistancePossible <= possibleDistance){
                    maxDistancePossible = possibleDistance;
                    nextPoint = j;
                }
            }
            i = nextPoint;
            jumps++;
        }
        return jumps;
    }
}
