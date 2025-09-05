class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        //List<List<Integer>> list = new ArrayList<>();
        HashSet<List<Integer>> listSet = new HashSet<>();
        int len = nums.length;
        for(int i=0; i<len; i++){
            HashSet<Integer> hset = new HashSet<>();
            //hset.add(nums[i]);
            for(int j=i+1; j<len; j++){
                int sum = nums[i] + nums[j];
                int toFind = 0 - sum;
                if(hset.contains(toFind)){
                    listSet.add(Arrays.asList(nums[i], nums[j], toFind));
                }
                hset.add(nums[j]);
            }
        }
        return new ArrayList<>(listSet);
    }
}