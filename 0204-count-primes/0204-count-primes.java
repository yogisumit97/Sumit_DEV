class Solution {
    public int countPrimes(int n) { // sieve of eratothenes
        boolean[] arr = new boolean[n]; //we will check index 2 to index n-1 : initially all false.
        //let's consider false as prime and we will update true when non prime.
        int count = 0;
        for(int i =2 ;i<arr.length; i++){
            if(arr[i]==true) continue; //non prime marked already
            count++; //increase prime count;
            int mul = 2; //3 6 9 12 .... mark 3 as prime and 3*2 onwards non prime
            while(i*mul<arr.length){
                arr[i*mul] = true; // marked non prime
                mul++;
            }
        }
        return count;
    }
}