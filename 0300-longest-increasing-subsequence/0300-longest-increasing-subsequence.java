class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            int index = findUpperBoundIndex(0, list.size()-1, list, nums[i]);
            if(index < 0 || index >= list.size()) list.add(nums[i]);
            else list.set(index, nums[i]);
        }
        //System.out.println(list);
        return list.size();
    }
    private int findUpperBoundIndex(int left, int right, List<Integer> list, int target){
        int l = left;
        int r = right;
        while(l <= r){
            int mid = (l+ r)/2;
            if(list.get(mid) < target) l = mid+1;
            else r = mid-1;
        }
        //System.out.println(list+"    "+ target+ "  "+ l);
        return l;
    }
}