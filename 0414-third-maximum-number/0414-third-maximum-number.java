class Solution {
    public int thirdMax(int[] nums) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        int update = 0;
        int minvalueSpotted = 0;
        for(int num : nums){
            if(num==Integer.MIN_VALUE && minvalueSpotted==0 && (first==Integer.MIN_VALUE || second== Integer.MIN_VALUE|| third ==Integer.MIN_VALUE)){
                minvalueSpotted = 1;
                update++;
                continue;
            }
            if(num>first){
                third = second;
                second = first;
                first = num;
                update++;
            }
            else if(num>second && num!=first){
                third = second;
                second = num;
                update++;
            }
            else if(num>third && num!=second && num!=first){
                update++;
                third = num;
            }
        }
        if(update>=3) return third;
        else return first;
    }
}