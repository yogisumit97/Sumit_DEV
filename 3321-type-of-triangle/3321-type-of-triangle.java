class Solution {
    public String triangleType(int[] nums) {
        String ans = "none";
        // Triangle Inequality Theorem: The sum of the lengths of any two sides of a triangle must be greater than the length of the third side. 
        if(nums[0]>=nums[1]+nums[2] || nums[1]>=nums[2]+nums[0] || nums[2]>=nums[0]+nums[1]){
            return ans;
        }
        if(nums[0]==nums[1] && nums[1]==nums[2]){
            ans = "equilateral";
        }
        else if(nums[0]==nums[1] || nums[1]==nums[2] || nums[0]==nums[2]){
            ans = "isosceles";
        }
        else{
            ans = "scalene";
        }
        return ans;
    }
}