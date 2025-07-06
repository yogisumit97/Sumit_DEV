class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        sumHelper(candidates, 0, target, 0, new ArrayList<Integer>(), list);
        return list;
    }
    private void sumHelper(int[] arr, int i, int tar, int sum, List<Integer> res, List<List<Integer>> list){
        if(sum==tar){
            list.add(new ArrayList<>(res));
            return;
        }
        for(int index= i; index<arr.length; index++){
            if(index>i && arr[index] == arr[index-1]) continue;
            if(sum+arr[index]>tar) break;
            res.add(arr[index]);
            sumHelper(arr, index+1, tar, sum+arr[index],res, list); //take
            res.remove(res.size()-1);
        }
    }
}