class Solution {
    public int characterReplacement(String s, int k) { // len of substring - maxFreq = no. of conversions <=k allowed
        int maxLen = 0;
        HashMap<Character,Integer> hm = new HashMap<>(); // stores character and it's freq
        int l=0; int r=0; // left and right pointers for 2 pointer + sliding window method.
        int maxFreq = 0;
        while(r<s.length()){
            char curr = s.charAt(r);
            hm.put(curr, hm.getOrDefault(curr, 0)+1);
            maxFreq = Math.max(hm.get(curr),maxFreq);
            // now check if adding this is valid or not : if valid update maxLen else shrink window
            int currLen = r-l+1;
            if(currLen-maxFreq <=k){ //valid case
                maxLen = Math.max(maxLen, currLen);
            }
            else{ //invalid case : shrink window and find maxFreq
                char left = s.charAt(l);
                hm.replace(left, hm.get(left)-1);
                if(hm.get(left)==0) hm.remove(left);
                l++;
                maxFreq = 0;
                for(int i : hm.values()){
                    maxFreq = Math.max(maxFreq, i); 
                }
            }
            r++;
        } 
        return maxLen;
    }
}