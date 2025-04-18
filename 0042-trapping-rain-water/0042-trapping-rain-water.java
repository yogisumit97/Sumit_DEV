class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] nextGreatest = new int[height.length];
        int[] prevGreatest = new int[height.length];
        int temp = -1;
        for(int i = len-1; i>=0; i--){
            nextGreatest[i] = Math.max(height[i], temp);
            temp = nextGreatest[i];
        }
        temp = -1;
        for(int i = 0; i<len; i++){
            prevGreatest[i] = Math.max(height[i], temp);
            temp = prevGreatest[i];
        }
        temp = 0;  // now temp will store volume
        for(int i =0; i<len; i++){
            temp+= Math.min(prevGreatest[i], nextGreatest[i]) - height[i];
        }
        return temp;
    }
}