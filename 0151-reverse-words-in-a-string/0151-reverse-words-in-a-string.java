class Solution {
    public String reverseWords(String s) {
        StringBuilder str = new StringBuilder();
        int first = 0; 
        int last = s.length()-1;
        while(s.charAt(first)==' ') first++; //removed initial spaces
        while(s.charAt(last)==' ') last--; //removed end spaces
        int currStart = last;
        for(int i =last; i>=first;i--){
            if((i==last && s.charAt(i)!=' ') || (s.charAt(i)!=' ' && s.charAt(i+1)==' ')){
                currStart = i;
                if(currStart==first) str.append(s.charAt(i));
                continue;
            }
            else if(s.charAt(i)==' ' && s.charAt(i+1)==' ') continue;
            else if(i==first){
                for(int j=i; j<=currStart;j++){
                    str.append(s.charAt(j));
                }
            }
            else if(s.charAt(i)!=' ') continue;
            else{ 
                for(int j=i+1; j<=currStart;j++){
                    str.append(s.charAt(j));
                }
                str.append(' ');
            }
        }
        //str.delete(str.length()-1,str.length());
        return str.toString();
    }
}