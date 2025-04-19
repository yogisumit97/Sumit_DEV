class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber>0){
            columnNumber--; //adjustment
            int remainder = columnNumber%26;
            columnNumber = columnNumber/26;
            char ch = (char)('A'+ remainder); 
            sb.append(ch);
        }
        return sb.reverse().toString();
    }
}