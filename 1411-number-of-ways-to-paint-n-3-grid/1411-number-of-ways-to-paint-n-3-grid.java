class Solution {
    private static final int MOD = 1_000_000_007;

    public int numOfWays(int n) { 
        long same = 6; // ABA type coloring >> 6 ways possible ryr, rgr, yry, ygy, grg, gyg
        long diff = 6; // ABC type coloring >> 6 ways possible ryg, rgy, yrg, ygr, gry, gyr

        for (int i = 2; i <= n; i++) {
            long newSame = (same * 3 + diff * 2) % MOD;
            long newDiff = (same * 2 + diff * 2) % MOD;
            same = newSame;
            diff = newDiff;
        }
        return (int)((same + diff) % MOD);
    }
}
