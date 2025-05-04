class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] freqA = new int[7];
        int[] freqB = new int[7];
        int[] same = new int[7];
        for(int i=0; i<tops.length; i++){
            freqA[tops[i]]++;
            freqB[bottoms[i]]++;
            if(tops[i]==bottoms[i]) same[tops[i]]++;
        }
        for(int i=1; i<7; i++){
            int curr = freqA[i] + freqB[i] - same[i];
            if(curr==tops.length) return Math.min(freqA[i], freqB[i])- same[i];
        }
        return -1;
    }
}

