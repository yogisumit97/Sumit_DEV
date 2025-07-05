class Solution {
    public int myAtoi(String input) {
        String temp = input.strip();
        if(temp==null || temp.length()<=0) return 0;
        if(temp.charAt(0)=='+') return findInt(temp, 0, 1,1);
        else if(temp.charAt(0)=='-') return findInt(temp, 0, 1, -1);
        else return findInt(temp, 0, 0, 1);
    }
    private int findInt(String input, long result, int start, int sign){
        if(start== input.length() || !Character.isDigit(input.charAt(start))) return (int)(result*sign);
        result = result*10+Character.getNumericValue(input.charAt(start));
        if(result*sign >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else if(result*sign<= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        else return findInt(input, result, start+1, sign);
    }
}