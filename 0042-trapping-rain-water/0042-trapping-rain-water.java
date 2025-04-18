class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int vol = 0;
        int leftMax = 0;
        int rightMax = 0;
        while(left<right){
            if(height[left]<=height[right]){
                leftMax = Math.max(leftMax,height[left]);
                vol+= leftMax-height[left];
                left++;
            }    
            else{
                rightMax = Math.max(rightMax,height[right]);
                vol+= rightMax-height[right];
                right--;
            }
            //System.out.println(left+" "+right+" "+leftMax+" "+rightMax+" "+vol);
        }
        return vol;
    }
}