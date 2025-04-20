class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int ans = 0;
        for(int num : answers){
            if(hm.containsKey(num)){
                hm.put(num, hm.get(num)+1);
                if(hm.get(num) <=num+1) continue;
                else{
                    hm.remove(num);
                }
            }
            ans+=1+num;
            hm.put(num,1);
            //System.out.println(ans+" "+ " "+ num + "  "+ hm);
        }
        return ans;
    }
}