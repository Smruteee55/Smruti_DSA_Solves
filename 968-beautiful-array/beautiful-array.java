class Solution {
    public int[] beautifulArray(int n) {
        
        // Base case
        if (n == 1) {
            return new int[]{1};
        }

        // Generate beautiful arrays for odd and even parts
        int[] left = beautifulArray((n + 1) / 2);
        int[] right = beautifulArray(n / 2);

        int[] ans = new int[n];
        int index = 0;

        // Convert to odd numbers
        for (int x : left) {
            ans[index++] = 2 * x - 1;
        }

        // Convert to even numbers
        for (int x : right) {
            ans[index++] = 2 * x;
        }

        return ans;
    }
}