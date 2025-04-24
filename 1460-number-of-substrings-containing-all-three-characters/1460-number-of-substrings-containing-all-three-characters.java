class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0;
        int[] hash = new int[3]; // all 3 stores lastSpottedAddress for corresponding characters a,b,c
        hash[0] = -1; hash[1] = -1; hash[2] = -1; //as storing index, initialize it with -1 
        for(int i =0; i<s.length(); i++){
            char curr = s.charAt(i);
            hash[curr-'a'] = i;
            if(hash[0]!=-1 && hash[1]!=-1 && hash[2]!=-1){
                count+= Math.min(hash[0], Math.min(hash[1],hash[2]))+1;
            }
        }
        return count;
    }
}