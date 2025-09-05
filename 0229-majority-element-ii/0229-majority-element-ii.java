class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int min = nums.length/3;
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums){
            freqMap.put(num, freqMap.getOrDefault(num,0)+1);
            if(freqMap.get(num) > min){
                if(list.size()==0) list.add(num);
                else if(list.size()==1 && list.get(0)!= num) list.add(num);
                else continue;
            }
        }
        return list;
    }    
}