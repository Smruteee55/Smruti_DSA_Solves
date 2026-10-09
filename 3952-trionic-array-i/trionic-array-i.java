
class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        int i = 0;

        // Part 1: Strictly increasing
        while (i < n - 2 && nums[i] < nums[i + 1]) {
            i++;
        }

        if (i == 0) {
            return false;
        }

        // Part 2: Strictly decreasing
        int j = i;

        while (j < n - 1 && nums[j] > nums[j + 1]) {
            j++;
        }

        if (j == i || j == n - 1) {
            return false;
        }

        // Part 3: Strictly increasing
        while (j < n - 1 && nums[j] < nums[j + 1]) {
            j++;
        }

        return j == n - 1;
    }
}