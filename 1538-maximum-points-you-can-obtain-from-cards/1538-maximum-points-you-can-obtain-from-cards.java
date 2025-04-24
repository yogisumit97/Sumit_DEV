class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int i = k;
        int j = cardPoints.length;
        int sum = 0;
        for(int temp = 0; temp <i; temp++) sum+= cardPoints[temp];
        for(int temp = j; temp<cardPoints.length; temp++) sum+=cardPoints[temp];
        int max = sum; //maxScore
        while(k>0){
            //System.out.println(sum);
            k--;
            i--;
            j--;
            sum-=cardPoints[i];
            sum+=cardPoints[j];
            max = Math.max(max,sum);
        }
        return max;
    }
}