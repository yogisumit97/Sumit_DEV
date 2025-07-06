class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        sumHelper(candidates, 0, target, 0, new ArrayList<Integer>(), list);
        return list;
    }
    private void sumHelper(int[] arr, int i, int tar, int sum, List<Integer> res, List<List<Integer>> list){
        if(i>=arr.length){
            if(sum==tar){
                list.add(new ArrayList<>(res));
            }
            return;
        }
        if(sum>tar) return;
        res.add(arr[i]);
        sumHelper(arr, i, tar, sum+arr[i],res, list); //take
        res.remove(res.size()-1);
        sumHelper(arr, i+1, tar, sum, res, list);
    }
}