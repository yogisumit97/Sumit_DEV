class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int majElement = Integer.MIN_VALUE;
        for(int i : nums){
            if(i==majElement) count++;
            else{
                if(count==0){
                    majElement = i;
                    count++;
                }
                else count--;
            }
        }
        return majElement;
    }
}