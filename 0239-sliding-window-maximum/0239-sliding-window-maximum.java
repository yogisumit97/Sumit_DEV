class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] ans = new int[len-k+1];
        Deque<Integer> dq = new ArrayDeque<>(); // storing index, in strictly decreasing manner.
        for(int i =0; i<len; i++){
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]) dq.pollLast();
            dq.addLast(i); 
            if(i>=k-1){
                int rangeStart = i-k+1;
                if(dq.peekFirst()<rangeStart) dq.pollFirst();
                ans[i-k+1] = nums[dq.peekFirst()];
            } 
        }
        return ans;
    }
}