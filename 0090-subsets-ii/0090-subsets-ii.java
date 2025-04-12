class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        findSubset(0, nums, new ArrayList<Integer>(), ans);
        return ans;
    }
    public void findSubset(int index,int[] nums, List<Integer> result, List<List<Integer>> ans){
        ans.add(new ArrayList<>(result)); //as java passes reference, always use new result
        for(int i = index; i<nums.length;i++){
            if(i!=index && nums[i]==nums[i-1]) continue;
            result.add(nums[i]); 
            findSubset(i+1, nums, result, ans);
            result.remove(result.size()-1); 
        }
        return;
    }
}

