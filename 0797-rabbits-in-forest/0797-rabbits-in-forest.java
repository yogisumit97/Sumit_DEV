class Solution {
    public int numRabbits(int[] answers) {
        Arrays.sort(answers);
        int prevNum = -1;
        int count = 0;        
        int ans = 0;
        for(int num : answers){
            if(num==prevNum && count<=num) count++;
            else{
                prevNum = num;
                count = 1;
                ans+=num+1;
            }
        }
        return ans;
    }
}