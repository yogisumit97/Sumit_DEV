class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        return findSubset(0, candidates, result,0, ans, target);
    }
    public List<List<Integer>> findSubset(int index,int[] nums, List<Integer> result,int sum, List<List<Integer>> ans, int target){
        if(index >= nums.length || sum>=target){ //base case
            if(sum==target) ans.add(new ArrayList<>(result)); //as java passes reference, take new 
            return ans;
        }

        //take or not take method
        result.add(nums[index]); //take
        sum+=nums[index];
        findSubset(index, nums, result,sum, ans,target);
        result.remove(result.size()-1); //not take
        sum-=nums[index];
        findSubset(index+1, nums, result,sum, ans, target);
        return ans;
    }
}



