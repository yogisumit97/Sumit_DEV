class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int el1 = Integer.MIN_VALUE;
        int cnt1 = 0;
        int el2 = Integer.MIN_VALUE;
        int cnt2 = 0;
        for(int num : nums){
            if(cnt1==0 && num !=el2){
                cnt1 = 1;
                el1 = num;
            }
            else if(cnt2==0 && num!= el1){
                cnt2 = 1;
                el2 = num;
            }
            else if(num==el1) cnt1++;
            else if(num==el2) cnt2++;
            else{
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = cnt2 = 0;
        for(int num : nums){
            if(num==el1) cnt1++;
            if(num==el2) cnt2++;
        }
        if(cnt1 > nums.length/3) list.add(el1);
        if(cnt2 > nums.length/3) list.add(el2);
        
        return list;
    }   
}