class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return generateSubsetsHelper(0, nums, new ArrayList<Integer>(), new ArrayList<List<Integer>>());
    }
    private List<List<Integer>> generateSubsetsHelper(int index, int[] nums, List<Integer> result,List<List<Integer>> ans){
        if(index>=nums.length){
            ans.add(new ArrayList<Integer>(result));
            return ans;
        }      
        result.add(nums[index]);//involve element in answer
        generateSubsetsHelper(index+1, nums, result, ans);
        result.remove(result.size()-1);// do not involve current element in the answer
        generateSubsetsHelper(index+1, nums, result, ans);
        return ans;
    }
}