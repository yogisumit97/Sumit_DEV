class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> hset = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        return new ArrayList<List<Integer>>(findSubset(0, nums, result, hset));
    }
    public HashSet<List<Integer>> findSubset(int index,int[] nums, List<Integer> result, HashSet<List<Integer>> ans){
        if(index >= nums.length){ //base case
            ans.add(new ArrayList<>(result)); //as java passes reference, always use new result
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

