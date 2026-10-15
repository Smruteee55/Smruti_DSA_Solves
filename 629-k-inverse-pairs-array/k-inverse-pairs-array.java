class Solution {
    public int kInversePairs(int n, int k) {
        int MOD = 1000000007;

        int[] dp = new int[k + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            int[] curr = new int[k + 1];
            curr[0] = 1;

            for (int j = 1; j <= k; j++) {
                curr[j] = (int) ((dp[j] + (long) curr[j - 1] - (j >= i ? dp[j - i] : 0) + MOD) % MOD);
            }

            dp = curr;
        }

        return dp[k];
    }
}