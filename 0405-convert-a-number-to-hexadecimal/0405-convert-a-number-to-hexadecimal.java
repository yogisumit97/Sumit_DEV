class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";
        
        char[] hexChars = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();
        
        while (num != 0) {
            int digit = num & 0xf; //num%16
            sb.append(hexChars[digit]);
            // Unsigned right shift by 4 bits to process next digit
            num >>>= 4; //num/16
        }
        return sb.reverse().toString();
    }
}