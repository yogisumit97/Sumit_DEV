class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        HashSet<List<Integer>> listSet = new HashSet<>();
        int len = nums.length;
        for(int i=0; i<len; i++){
            for(int k=i+1; k<len; k++){
                HashSet<Integer> hset = new HashSet<>();
                for(int j=k+1; j<len; j++){
                    long sum = (long)nums[i] + nums[j] + nums[k];
                    if(sum>Integer.MAX_VALUE || sum< Integer.MIN_VALUE) continue;
                    int toFind = target - (int)sum;
                    if(hset.contains(toFind)){
                        listSet.add(Arrays.asList(nums[i], nums[k], nums[j], (int)toFind));
                    }
                    hset.add(nums[j]);
                }
            }
        }
        return new ArrayList<>(listSet);
    }
}
