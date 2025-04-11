class Solution {
    public char kthCharacter(int k) {
        return findChar("a",k);
    }
    public char findChar(String result, int k){
        if(result.length()>=k) return result.charAt(k-1); //base case
        String temp=result;
        for(int i =0; i<result.length();i++){ //change
            temp = temp +(char)(result.charAt(i)+1);     
        }
        return findChar(temp,k);// recursive call
    }
}