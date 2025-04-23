class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer,Integer> mpp = new HashMap<>();
        int count = -1;
        for(int num : arr){
            mpp.put(num, mpp.getOrDefault(num,0)+1);
        }
        for(int key : mpp.keySet()){
            if(key ==mpp.get(key)) count = Math.max(count,key);
        }
        return count;
    }
}