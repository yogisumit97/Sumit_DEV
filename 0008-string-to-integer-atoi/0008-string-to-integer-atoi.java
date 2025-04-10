class Solution {
    public int myAtoi(String s) {
        String temp = s.trim();
        if(temp.length()==0) return 0;
        int sign = 1;
        if(temp.charAt(0)=='-'){
            temp = temp.substring(1,temp.length());
            sign = -1;
        }
        else if(temp.charAt(0)=='+') temp = temp.substring(1,temp.length());
        return getNumber(temp,sign);
    }
    public int getNumber(String s, int sign){
        int num = 0;
        for(int i =0;i<s.length();i++){
            if(!Character.isDigit(s.charAt(i))) break;
            int digit = (s.charAt(i)-'0');
            // Check for overflow
            if (num > Integer.MAX_VALUE / 10 || 
                (num == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num*10+ digit;
        }
        return sign*num;
    }
}