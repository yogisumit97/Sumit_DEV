class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        int hI = 0;
        for(int i =0; i<len; i++){
            hI = Math.max(hI, Math.min(citations[i], len-i));
        }
        return hI;
    }
}