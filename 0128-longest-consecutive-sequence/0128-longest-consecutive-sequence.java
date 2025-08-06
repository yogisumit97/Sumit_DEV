class Solution {
    public int longestConsecutive(int[] nums) {
        // put everything in HashSet
        HashSet<Integer> set = new HashSet<>(); 
        for(int i : nums){
            set.add(i);
        }
        // now iterate in set and on value for which v-1 doesnt exist, count length of lc >> probable starting point only 
        int count = 0;
        int longest = 0;
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
            int num = iterator.next();
            if(set.contains(num-1)) continue;
            // no num-1, so it is a probable candidate 
            while(set.contains(num)){
                num++;
                count++;
            }
            longest = Math.max(longest, count);
            count = 0;
        }
        return longest;
    }
}