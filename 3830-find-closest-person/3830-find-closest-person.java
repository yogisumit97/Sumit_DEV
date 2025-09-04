class Solution {
    public int findClosest(int x, int y, int z) {
        int first = Math.abs(x-z);
        int second = Math.abs(y-z);
        if(first == second) return 0;
        return first>second ? 2 : 1;
    }
}