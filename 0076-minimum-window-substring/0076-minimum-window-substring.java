class Solution {
    public String minWindow(String s, String t) {
        String answer = "";
        int[] hash = new int[256];
        for(int i=0; i<t.length(); i++) hash[t.charAt(i)]++;
        int l = 0;
        int r = 0;
        int count = 0;
        while(r<s.length()){
            char curr = s.charAt(r);
            if(hash[curr]>0){//exists in t and s both
                count++;    
            }
            while(count==t.length()){ // shrink window
                if(answer.length()==0) answer = s.substring(l,r+1);
                else answer = answer.length() > r-l+1 ? s.substring(l,r+1) : answer;
                char temp = s.charAt(l);
                hash[temp]++;
                l++;
                if(hash[temp]>0) count--;
                continue;
            }
            hash[curr]--;
            r++;
        }
        return answer;
    }
}