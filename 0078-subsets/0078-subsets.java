class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        subsetsHelper(nums, 0, new ArrayList<Integer>(), list);
        return list;
    }
    private void subsetsHelper(int[] nums, int i, List<Integer> res, List<List<Integer>> list){
        if(i>=nums.length){
            list.add(new ArrayList<>(res));
            return;
        }
        res.add(nums[i]); // take and not take method
        subsetsHelper(nums, i+1, res, list); //take
        res.remove(res.size()-1);
        subsetsHelper(nums, i+1, res, list); // not take
    }
}