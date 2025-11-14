class Solution {
    public int myAtoi(String s) {
        String t = s.strip();
        if(t.length()==0) return 0;
        int sign = 1;
        if(t.charAt(0)=='-'){
            t = t.substring(1, t.length());
            sign = -1;
        }
        else if(t.charAt(0)=='+'){
            t = t.substring(1, t.length());
            sign = 1;
        }
        long num = 1L*sign*findNum(t, 0, 0);
        if(num>Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else if(num<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        else return (int)num;
    }
    private long findNum(String t, int i, long num){
        if(i>=t.length()) return num;
        char ch = t.charAt(i);
        if(ch>='0' && ch<='9'){
            num = num*10l+(int)(ch-'0');
            if(num>=Integer.MAX_VALUE+1L) return num;
            return findNum(t, i+1, num);
        }
        else return num;
    }
}