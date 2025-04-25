class KthLargest {
    PriorityQueue<Integer> pq;
    int count;
    public KthLargest(int k, int[] nums) {
        count = k;
        pq = new PriorityQueue<>(); //min Heap;
        if(nums.length<=k){
            for(int i=0; i<nums.length ; i++){
                pq.offer(nums[i]);
            }   
            //System.out.println(pq);
            return;
        }
        for(int i=0; i<k ; i++){
            pq.offer(nums[i]);
        }
        for(int i=k; i<nums.length ; i++){
            if(nums[i]>pq.peek()){
                pq.poll();
                pq.offer(nums[i]);
            }
        }
        //System.out.println(pq);
    }
    public int add(int val) {
        if(pq.size()<count){
            pq.offer(val);
            //System.out.println(pq);
            return pq.peek();
        }
        if(val>pq.peek()){
            pq.poll();
            pq.offer(val);
        }
        //System.out.println(pq);
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */