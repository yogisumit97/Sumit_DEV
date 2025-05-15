class Solution {
    public int[] findEvenNumbers(int[] digits) {
        List<Integer> list = new ArrayList<>();
        int[] map = new int[10]; // digits can be 0 to 9 only
        for(int i : digits) map[i]++;
        // suppose number is ijk then i can be 1 to 9, j can be 0 to 9 and k can be even only.
        for(int i=1; i<=9; i++){
            if(map[i]==0) continue;
            else map[i]--;
            for(int j=0; j<=9; j++){
                if(map[j]==0) continue;
                else map[j]--;
                for(int k=0; k<=8; k+=2){
                    if(map[k]==0) continue;
                    else map[k]--;
                    list.add(i*100+j*10+k);
                    map[k]++;
                }
                map[j]++;    
            }
            map[i]++;
        }
        int[] result = new int[list.size()];
        int count = 0;
        for(int i : list) result[count++] = i;
        return result;
    }
}