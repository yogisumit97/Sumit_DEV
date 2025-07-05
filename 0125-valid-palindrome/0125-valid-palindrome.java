class Solution {
    public boolean isPalindrome(String s) {
        String temp = s.toLowerCase();
        return check(temp, 0, s.length()-1);
    }
    private boolean check(String s, int start, int end){
        if(start>=end) return true;
        if(!Character.isLetterOrDigit(s.charAt(start))) return check(s, start+1, end);
        if(!Character.isLetterOrDigit(s.charAt(end))) return check(s, start, end-1);
        if(s.charAt(start) != s.charAt(end)) return false;
        return check(s, start+1, end-1);
    }
}