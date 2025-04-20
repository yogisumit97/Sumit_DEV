class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer> mpp = new HashMap<>();
        int ans = 0;
        for(int num : answers) mpp.put(num+1, mpp.getOrDefault(num+1,0)+1);
        for(Map.Entry<Integer, Integer> mapEntry : mpp.entrySet()){
            ans+= mapEntry.getKey()*(Math.ceil(mapEntry.getValue()*1.0/mapEntry.getKey()));
        }
        return ans;
    }
}