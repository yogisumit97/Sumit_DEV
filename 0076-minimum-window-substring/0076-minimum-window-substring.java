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
            if(hash[curr]<=0){
                hash[curr]--;    
            }
            else{ //exists in t and s both
                hash[curr]--;
                count++;
            }
            while(count==t.length()){ // shrink window
                //System.out.println(s.substring(l,r+1));
                if(answer.equals("")) answer = s.substring(l,r+1);
                else answer = answer.length() > r-l+1 ? s.substring(l,r+1) : answer;
                char temp = s.charAt(l);
                hash[temp]++;
                l++;
                if(hash[temp]>0) count--;
                //System.out.println("Equal now : "+answer+" "+" "+l+" "+count);
                continue;
            }
            //System.out.print(count+" ");
            //System.out.println(curr);
            r++;
        }
        return answer;
    }
}