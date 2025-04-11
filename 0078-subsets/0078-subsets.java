class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        return findSubset(0, nums, result, ans);
    }
    public List<List<Integer>> findSubset(int index,int[] nums, List<Integer> result, List<List<Integer>> ans){
        if(index >= nums.length){ //base case
            ans.add(new ArrayList<>(result)); //as java passes reference, and we are updating result thus always make new arraylist to add in ans
            return ans;
        }

        //take or not take method
        result.add(nums[index]); //take
        findSubset(index+1, nums, result, ans);
        result.remove(result.size()-1); //not take
        findSubset(index+1, nums, result, ans);
        return ans;
    }
}