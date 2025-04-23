class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer,Integer> mpp = new HashMap<>();
        int count = -1;
        for(int num : arr){
            mpp.put(num, mpp.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : mpp.entrySet()){
            if(entry.getKey()==entry.getValue()) count = Math.max(count, entry.getKey());
        }
        return count;
    }
}