class Solution {
    public int romanToInt(String s) {
        int op=0;
        int len = s.length();
        //System.out.println(len);
        for(int i=0; i<len; i++){
            char ch= s.charAt(i);
            if(ch == 'M' && i!=0 && (s.charAt(i-1)=='C')){
                op+=800;
            }
            else if(ch == 'M') op+=1000;
            else if(ch == 'D' && i!=0 && (s.charAt(i-1)=='C')){
                op+=300;
            }
            else if(ch == 'D') op+=500;
            else if(ch == 'C' && i!=0 && (s.charAt(i-1)=='X')){
                op+=80;
            }
            else if(ch == 'C') op+=100;
            else if(ch == 'L' && i!=0 && (s.charAt(i-1)=='X')){
                op+=30;
            }
            else if(ch == 'L') op+=50;
            else if(ch == 'X' && i!=0 && (s.charAt(i-1)=='I')){
                op+=8;
            }
            else if(ch == 'X') op+=10;
            else if(ch == 'V' && i!=0 && (s.charAt(i-1)=='I')){
                op+=3;
            }
            else if(ch == 'V') op+=5;
            else op+=1;            
        }
        return op;
    }
}