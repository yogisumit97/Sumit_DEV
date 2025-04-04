class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character,Character> hm = new HashMap<>();
        for(int i =0; i<s.length(); i++){ //store s' character as key and t's character as value
            if(hm.containsKey(s.charAt(i))){
                if(hm.get(s.charAt(i))!=t.charAt(i)) return false; //for same key val differs not isomorphic
            }
            else if(hm.containsValue(t.charAt(i))) return false;
            else hm.put(s.charAt(i),t.charAt(i)); //store s' character as key and t's character as value
        }
        return true;
    }
}