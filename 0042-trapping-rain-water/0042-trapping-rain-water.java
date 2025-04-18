class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] nextGreatest = new int[height.length]; // keep track of next greatest element
        int temp = -1;
        for(int i = len-1; i>=0; i--){
            nextGreatest[i] = Math.max(height[i], temp);
            temp = nextGreatest[i];
        }
        temp = -1;   // to store prevGreatest occured till now
        int vol = 0;
        for(int i =0; i<len; i++){
            temp = Math.max(height[i], temp);
            vol+= Math.min(temp, nextGreatest[i]) - height[i];
        }
        return vol;
    }
}

/*
temp = -1;
for(int i = 0; i<len; i++){
            prevGreatest[i] = Math.max(height[i], temp);
            temp = prevGreatest[i];
        }
        */