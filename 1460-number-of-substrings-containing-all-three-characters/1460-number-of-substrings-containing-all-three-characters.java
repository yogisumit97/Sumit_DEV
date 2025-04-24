class Solution {
    public int numberOfSubstrings(String s) {
        int len = s.length();
        int count = 0;
        int l = 0;
        int r = 0;
        int[] hash = new int[3];// to track freq of a,b,c
        while(r<len){
            char curr = s.charAt(r);
            hash[curr-'a']++;
            if(hash[0]>0 && hash[1]>0 && hash[2]>0){ //all 3 present, count and shrink window.
                //System.out.println(s.substring(l,r+1)+" "+ curr+" "+hash[0]+hash[1]+hash[2]+" "+count);
                while(hash[0]!=0 && hash[1]!=0 && hash[2]!=0){
                    char ch = s.charAt(l);
                    hash[ch-'a']--;
                    count+=len-r;
                    l++;
                }
            }
            //System.out.println(s.substring(l,r+1)+" "+ curr+" "+hash[0]+hash[1]+hash[2]+" "+count);
            r++;
        }
        return count;
    }
}