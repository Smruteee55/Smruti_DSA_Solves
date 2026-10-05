class Solution {
    public int numberOfArrays(String s, int k) {
        int n = s.length();
        int MOD = 1_000_000_007;

        long[] dp = new long[n + 1];

        // Empty string has 1 way
        dp[n] = 1;

        for (int i = n - 1; i >= 0; i--) {

            // Number cannot start with 0
            if (s.charAt(i) == '0') {
                continue;
            }

            long num = 0;

            for (int j = i; j < n; j++) {

                num = num * 10 + (s.charAt(j) - '0');

                // Number is too large
                if (num > k) {
                    break;
                }

                dp[i] = (dp[i] + dp[j + 1]) % MOD;
            }
        }

        return (int) dp[0];
    }
}