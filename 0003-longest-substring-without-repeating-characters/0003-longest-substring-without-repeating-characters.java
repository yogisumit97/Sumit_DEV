class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        int[] hm = new int[256]; // for hashing on characters.
        int maxLen = -1;
        int l = 0;
        int r = 0;
        while(r<s.length()){
            char ch = s.charAt(r);
            if(hm[ch] != 0){
                while(s.charAt(l)!=ch){
                    hm[s.charAt(l)] = 0;
                    l++;
                }
                l++;
            }
            hm[ch] = r+1;
            maxLen = Math.max(maxLen,r-l+1);
            r++;
        }
        return maxLen;
    }
}