class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // dp solution 
        int maxLen = Integer.MIN_VALUE; // if substring is greater than this do not check further
        HashSet<String> dictSet = new HashSet<>();
        for(String i : wordDict){
            dictSet.add(i);
            maxLen = Math.max(maxLen,i.length());
        }
        boolean[] isSegmentPossible = new boolean[s.length()+1]; //dp array : keeps track if substring(0,i+1) is possible or not using this dictionary
        isSegmentPossible[0]=true; // if nothing is taken segment is possible;
        for(int i =0 ; i<s.length(); i++){ // iterate over string
            int count = 0;
            for(int j=i; j>=0 && count!=maxLen; j--){
                if(checkDictionary(s.substring(j,i+1),dictSet)){
                    isSegmentPossible[i+1] =isSegmentPossible[i+1] || isSegmentPossible[j]; 
                }
                count++;
            }
        }
        return isSegmentPossible[s.length()];
    }
    public boolean checkDictionary(String s, HashSet<String> dict){
        if(dict.contains(s)) return true;
        return false;
    }
}
