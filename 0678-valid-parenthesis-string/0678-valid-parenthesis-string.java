class Solution {
    public boolean checkValidString(String s) {
        //maintain range of answer using min max, if in end 0 is acheivable return true else false.
        int min = 0;
        int max = 0;
        for(int i =0; i<s.length(); i++){
            char curr = s.charAt(i);
            if(curr=='('){ 
                min++;
                max++;
            }
            else if(curr=='*'){ //dont take anything min stays same. take it max increases. thus range.
                min--;
                max++;
            }
            else if(curr==')'){
                min--;
                max--;
            }
            //System.out.println(curr+" "+min+" "+max);
            if(max<0) return false;
            if(min<0) min = 0;
        }
        return min==0? true : false;
    }
}