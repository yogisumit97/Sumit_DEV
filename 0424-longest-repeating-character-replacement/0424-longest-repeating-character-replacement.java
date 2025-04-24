class Solution {
    public int characterReplacement(String s, int k) { // len of substring - maxFreq = no. of conversions <=k allowed
        int maxLen = 0;
        int[] hash = new int[26]; // stores character's freq
        int l=0; int r=0; // left and right pointers for 2 pointer + sliding window method.
        int maxFreq = 0;
        while(r<s.length()){
            char curr = s.charAt(r);
            maxFreq = Math.max(++hash[curr-'A'],maxFreq);
            // now check if adding this is valid or not : if valid update maxLen else shrink window
            int currLen = r-l+1;
            if(currLen-maxFreq <=k){ //valid case
                maxLen = Math.max(maxLen, currLen);
            }
            else{ //invalid case : shrink window and find maxFreq
                char left = s.charAt(l);
                hash[left-'A']--;
                l++;
                maxFreq = 0;
                for(int i : hash){
                    if(i==0) continue;
                    maxFreq = Math.max(maxFreq, i); 
                }
            }
            r++;
        } 
        return maxLen;
    }
}