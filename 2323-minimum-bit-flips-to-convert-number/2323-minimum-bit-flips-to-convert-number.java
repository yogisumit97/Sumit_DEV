class Solution {
    public int minBitFlips(int start, int goal) {
        int dig1 = 0;
        int dig2 = 0;
        int count = 0;
        while(start!=0 || goal!=0){
            dig1 = start&1;
            dig2 = goal&1;
            if(dig1!=dig2) count++;
            start>>=1;
            goal>>=1;
        }
        return count;
    }
}

