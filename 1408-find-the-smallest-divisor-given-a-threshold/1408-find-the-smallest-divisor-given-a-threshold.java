class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1;
        int r = 0;
        for(int i : nums) r = Math.max(i, r);
        while(l<=r){
            int m = (l+r)/2;
            int cnt = 0;
            for(int i : nums) cnt+= Math.ceil(1.0*i/m);
            if(cnt > threshold) l = m+1;
            else r = m-1;
        }
        return l;
    }
}