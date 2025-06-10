class Solution {
    public int maxDifference(String s) {
        int[] hm = new int[26];
        for(int i=0; i<s.length();i++){
            hm[s.charAt(i)-'a']++;
        }
        int biggestOdd = Integer.MIN_VALUE;
        int smallestEven = Integer.MAX_VALUE;
        for(int i : hm){
            if(i%2==0 && i!=0){
                smallestEven = Math.min(smallestEven, i);
            }
            else{
                biggestOdd = Math.max(biggestOdd, i);
            }
        }
        /*for(int i=0;i<26;i++){
            System.out.print(hm[i]+" ");
        }
        System.out.println("\n"+biggestOdd+" "+smallestEven);
        */
        return biggestOdd - smallestEven;
    }
}