class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> sumFreqMap = new HashMap<>(); 
        sumFreqMap.put(0, 1); // sum = 0, occured 1 time, initialization
        int preSum = 0;
        int count = 0;
        for(int curr : nums){
            preSum+= curr;
            if(sumFreqMap.containsKey(preSum-k)){
                count+= sumFreqMap.get(preSum-k);
            }
            sumFreqMap.put(preSum, sumFreqMap.getOrDefault(preSum, 0)+1);
        }
        return count;
    }
}