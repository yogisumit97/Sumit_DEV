class Solution { //can be done using sliding window technique
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = 0;
        int right = 0;
        while(right<s.length()){
            HashSet<Character> hset = new HashSet<>();
            for(int i = left; i<=right; i++){
                if(hset.contains(s.charAt(i))){
                    hset.clear();
                    left++;
                    break;
                }
                hset.add(s.charAt(i));
            }
            max = Math.max(max, hset.size());
            right++;
        }
        return max;
    }
}