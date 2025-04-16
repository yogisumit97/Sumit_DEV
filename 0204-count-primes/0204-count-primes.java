class Solution {
    public int countPrimes(int n) { // sieve of eratothenes
        boolean[] arr = new boolean[n]; //we will check index 2 to index n-1 : initially all false.
        //let's consider false as prime and we will update true when non prime.
        int count = 0;
        for(int i =2 ;i*i<arr.length; i++){ // till sqrt only
            if(arr[i]==true) continue; //non prime marked already
            //3 6 9 12 .... mark 3 as prime and 3*3 onwards non prime check >> 3*2 already checked by 2
            for(long j = (long)i*i; j<arr.length; j=j+i){
                arr[(int)j] = true; // marked non prime
            }
        }
        for(int i =2; i<arr.length;i++){
            if(arr[i]==false) count++;
        }
        return count;
    }
}