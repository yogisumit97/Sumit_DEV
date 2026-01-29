class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for(int num : nums){
            if(num < 0) num*=-1;
            if(nums[num-1] > 0) nums[num-1] = -1*nums[num-1]; // mark
        }
        //for(int num : nums) System.out.print(num+" ");
        //System.out.println();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
           if(nums[i]>0) list.add(i+1);
        }
        return list;
    }
}