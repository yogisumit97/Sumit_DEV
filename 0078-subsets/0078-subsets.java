class Solution {
    public List<List<Integer>> subsets(int[] nums) { // using bit powerset technique
        int subsets = 1<<(nums.length); // 2^n
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<subsets; i++){ // ex. for 3 no. 0 to 7 check as 8 total subsets possible
            //i is the no. of current subset, check it's ith bit is set or not for taking nums[i]
            List<Integer> list = new ArrayList<>();
            for(int j=0; j<nums.length; j++){
                if((i&(1<<j))!=0) list.add(nums[j]);//meas bit is set for this num, add it in list.
            }
            ans.add(list);
        }
        return ans;
    }
}