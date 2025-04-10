class Solution {
    public void reverseString(char[] s) {
        int num = 1;
        reverseArray(s,num);
    }
    public void reverseArray(char[] s, int num){
        if(num>s.length) return; // base case
        char ch = s[num-1];
        reverseArray(s,num+1);
        s[s.length-num] = ch;
    }
}