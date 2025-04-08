class Solution {
    public int beautySum(String s) {
        //edge case : till 2 size beauty is always 0
        if(s.length()<=2) return 0;
        int beauty = 0;
        for(int i =0; i<s.length()-2;i++){ // for substring where size is more than 2
            int[] freq =  new int[26];
            freq[s.charAt(i)-'a']++;
            freq[s.charAt(i+1)-'a']++;
            for(int j = i+2; j<s.length();j++){
                freq[s.charAt(j)-'a']++;
                beauty+=max(freq)-min(freq); 
            }
        }
        return beauty;
    }
    public int max(int[] freq){
        int ans = Integer.MIN_VALUE;
        for(int i : freq){
            if(i!=0) ans = Math.max(ans,i);
        }
        return ans;
    }
    public int min(int[] freq){
        int ans = Integer.MAX_VALUE;
        for(int i : freq){
            if(i!=0) ans = Math.min(ans,i);
        }
        return ans;
    }
}