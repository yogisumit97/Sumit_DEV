class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int l = 0; 
        int r = 0;
        int maxLen = 0;
        while(r<fruits.length){
            if(hm.size()>2){
                int freq = hm.get(fruits[l]);
                if(freq==1){
                    hm.remove(fruits[l]);
                }
                else{
                    hm.put(fruits[l], freq-1);
                }
                l++;
                continue;
            }
            hm.put(fruits[r], hm.getOrDefault(fruits[r],0)+1);
            if(hm.size()<=2) maxLen = Math.max(maxLen,r-l+1);
            //System.out.println(maxLen+" "+r+" "+hm);
            r++;
        }
        return maxLen;
    }
}