class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer> mpp = new HashMap<>();
        int ans = 0;
        for(int num : answers) mpp.put(num, mpp.getOrDefault(num,0)+1);
        for(Map.Entry<Integer, Integer> mapEntry : mpp.entrySet()){
            int num = mapEntry.getKey()+1;
            int res = mapEntry.getValue();
            ans+= num*(Math.ceil(res*1.0/num));
        }
        return ans;
    }
}