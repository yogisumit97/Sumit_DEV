class Solution {
    public void reverseString(char[] s) {
        reverseArray(s,0, s.length-1);
    }
    public void reverseArray(char[] s, int i, int j){
        if(i>=j) return; // base case
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
        reverseArray(s,i+1, j-1); //recursive call with change
    }
}