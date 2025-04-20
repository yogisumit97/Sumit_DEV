class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int ans = 0;
        for(int num : answers){
            if(hm.containsKey(num) && num!=0){
                hm.put(num, hm.get(num)+1);
                if(hm.get(num) ==num+1) hm.remove(num);
                continue;
            }
            ans+=1+num;
            hm.put(num,1);
        }
        return ans;
    }
}