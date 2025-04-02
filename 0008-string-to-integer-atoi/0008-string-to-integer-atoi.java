class Solution {
    public int myAtoi(String s) {
        int sign = 1;
        int ans = 0;
        int oper = 0;
        for(int i =0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c==' ' && oper ==0) continue;
            else if(c=='-' && oper ==0){
                sign = -1; oper=1;
            } 
            else if(c=='+' && oper==0){
                sign = 1; oper =1;
            }
            else if(!Character.isDigit(c)) break;
            else{
                oper = 1;
                if(ans>Integer.MAX_VALUE/10){
                    if(sign<0) return Integer.MIN_VALUE;
                    else return Integer.MAX_VALUE;
                }
                else if(ans<Integer.MIN_VALUE/10){
                    if(sign<0) return Integer.MIN_VALUE;
                    else return Integer.MAX_VALUE;
                } 
                ans = ans*10+ Character.getNumericValue(c);
                if(ans<0 && sign ==1) return Integer.MAX_VALUE;
                else if(ans<0 && sign ==-1) return Integer.MIN_VALUE;
            }
        }
        return sign*ans;
    }
}