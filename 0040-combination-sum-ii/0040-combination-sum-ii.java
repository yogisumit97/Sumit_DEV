class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        return findSubset(0, candidates,new ArrayList<Integer>(),0, ans, target);
    }
    public List<List<Integer>> findSubset(int index,int[] nums, List<Integer> result,int sum, List<List<Integer>> ans, int target){
        if(index >= nums.length || sum>=target){ //base case
            if(sum==target) ans.add(new ArrayList<>(result)); //as java passes reference, take new 
            return ans;
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue; // Skip duplicates
            result.add(nums[i]); // Include the current number
            findSubset(i + 1, nums, result, sum + nums[i], ans, target); // Move to the next index with the current number included
            result.remove(result.size() - 1); // Backtrack: remove the last added number
        }
        return ans;
    }
}



