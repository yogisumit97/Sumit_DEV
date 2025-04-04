class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> hm = new HashMap<>(); // hashMap with freq
        for(int i =0; i<s.length();i++) hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i),0)+1);
        StringBuilder ans = new StringBuilder();
        ArrayList<Character> list = new ArrayList(hm.keySet());
        list.sort((ob1,ob2) -> hm.get(ob2)-hm.get(ob1));  //decresing order as ob2-ob1 checked for ob1,ob2
        for(char ch : list){
            for(int i =0; i<hm.get(ch); i++) ans.append(ch);
        }
        return ans.toString();
	}
}