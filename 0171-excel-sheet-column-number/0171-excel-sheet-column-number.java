class Solution {
    public int titleToNumber(String columnTitle) {
        int count = 0;
        for(int i = columnTitle.length()-1; i>=0; i--){
            int temp = columnTitle.charAt(i) - 'A' + 1;
            count+= temp*Math.pow(26,columnTitle.length()-i-1);
        }
        return count;
    }
}