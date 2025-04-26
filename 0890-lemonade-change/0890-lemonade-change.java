class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] galla = new int[3]; // 5 10 20 only, and initially all 0. 
        for(int note : bills){
            if(note == 5) galla[0]++; //increase 5 rupee notes 
            else if(note == 10){
                if(galla[0]==0) return false; //no 5 rupee note to give
                else galla[0]--;
                galla[1]++;
            }
            else{
                if(galla[0]==0) return false;
                if(galla[1] !=0){
                    galla[1]--; //one 10 ruppe note
                    galla[0]--; // one 5 rupee note
                }
                else{
                    if(galla[0]>=3) galla[0]-=3; //5*3 notes
                    else return false;
                }
                galla[2]++;
            }
            //System.out.println(note + " Galla: "+galla[0]+" "+galla[1]+" "+galla[2]);
        }
        return true;
    }
}