class Solution {
    public String largestOddNumber(String num) {
        StringBuilder sb = new StringBuilder();
        for(int i =num.length()-1; i>=0; i--){
            int val = Character.getNumericValue(num.charAt(i));
            if(val%2==0) continue;
            else{
                sb.append(num.substring(0,i+1));
                break;
            }
        }
        return sb.toString();
    }
}