class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i = digits.length-1; i>=0; i--){
            int num = digits[i] + carry;
            carry = num/10;
            digits[i] = num%10;
            if(carry == 0) return digits;
        }
        int[] arr = new int[digits.length+1];
        arr[0] = carry;
        for(int i =1; i<=digits.length; i++) arr[i] = digits[i-1];
        return arr;
    }
}