class Solution {
    public String convert(String s, int numRows) {
        if(s.equals("")) return "";
        int m = (int)Math.ceil(s.length()*1.0*(numRows-1)/(numRows*2-2));
        if(numRows==1) return s;
        char[][] arr = new char[numRows][m];
        int i =0;
        int j =0;
        boolean goingDown = true; // o means go down and 1 means up.
        for(int k=0;k<s.length();k++){
            arr[i][j] = s.charAt(k);
            if(goingDown){
                if(i==numRows-1){
                    goingDown = false;
                    i--;
                    j++;
                }
                else i++;
            }
            else{
                if(i==0){
                    goingDown = true;
                    i++;
                }
                else{
                    i--;
                    j++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int p =0; p<numRows; p++){
            for(int l=0; l<m; l++){
                if(arr[p][l]!=0) sb.append(arr[p][l]);
            }
        }
        return sb.toString();
    }
}