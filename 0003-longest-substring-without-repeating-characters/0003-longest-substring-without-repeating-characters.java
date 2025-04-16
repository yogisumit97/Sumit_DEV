class Solution { //can be done using sliding window technique
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = 0;
        int right = 0;
        HashSet<Character> hset = new HashSet<>();
        while(right<s.length()){
            char curr = s.charAt(right);
            while(hset.contains(curr)){
                hset.remove(s.charAt(left));
                left++;
            }
            hset.add(curr);
            max = Math.max(max, right-left+1);
            right++;
        }
        return max;
    }
}