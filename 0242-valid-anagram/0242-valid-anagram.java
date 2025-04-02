class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        char[] sC= s.toCharArray();
        Arrays.sort(sC);
        char[] tC= t.toCharArray();
        Arrays.sort(tC);
        for(int i =0; i<s.length();i++){
            if(sC[i] != tC[i]) return false;
        }
        return true;       
    }
}