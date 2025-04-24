class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> hset = new HashSet<>();
        for(int i : nums) hset.add(i);
        return countSubarraysHelper(nums, hset.size());
    }
    private int countSubarraysHelper(int[] arr, int elements) {
        int count = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();// to track indexes
        for(int i =0; i<arr.length;i++){
            hm.put(arr[i],i);
            if(hm.size()==elements){ //all present, count and shrink window.
                if(hm.size()==elements){
                    //count+=min of hashmap values +1
                    int min = Integer.MAX_VALUE;
                    for(int value : hm.values()) min = Math.min(min, value);
                    count+= min+1;
                }
            }
        }
        return count;
    }
}


