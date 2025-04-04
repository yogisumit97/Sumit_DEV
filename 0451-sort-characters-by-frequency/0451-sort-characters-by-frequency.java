class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> hm = new HashMap<>(); // hashMap with freq
        for(int i =0; i<s.length();i++) hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i),0)+1);
        StringBuilder ans = new StringBuilder();
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(hm.entrySet());
        list.sort(Map.Entry.comparingByValue());
        list.forEach( (point) -> { 
            for(int i =point.getValue()-1; i>=0;i--) ans.append(point.getKey());
         } );
        return ans.reverse().toString();
	}
}