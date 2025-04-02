class Solution {
    public String largestOddNumber(String num) {
        String str="";
        for(int i =num.length()-1; i>=0; i--){
            int val = (int)num.charAt(i)-(int)'0';
            if(val%2==0) continue;
            else{
                return num.substring(0,i+1);
            }
        }
        return str;
    }
}