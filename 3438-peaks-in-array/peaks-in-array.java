import java.util.*;

class Solution {
    int[] bit;
    int n;
    int[] nums;

    void add(int index, int value) {
        index++;

        while (index <= n) {
            bit[index] += value;
            index += index & -index;
        }
    }

    int sum(int index) {
        int result = 0;
        index++;

        while (index > 0) {
            result += bit[index];
            index -= index & -index;
        }

        return result;
    }

    boolean isPeak(int i) {
        if (i <= 0 || i >= n - 1) {
            return false;
        }

        return nums[i] > nums[i - 1] &&
               nums[i] > nums[i + 1];
    }

    public List<Integer> countOfPeaks(int[] nums, int[][] queries) {

        this.nums = nums;
        n = nums.length;

        bit = new int[n + 1];

        // Add all initial peaks
        for (int i = 1; i < n - 1; i++) {
            if (isPeak(i)) {
                add(i, 1);
            }
        }

        List<Integer> answer = new ArrayList<>();

        for (int[] query : queries) {

            // Type 1: count peaks between l and r
            if (query[0] == 1) {

                int l = query[1];
                int r = query[2];

                if (r - l <= 1) {
                    answer.add(0);
                } else {
                    answer.add(sum(r - 1) - sum(l));
                }
            }

            // Type 2: update nums[index]
            else {

                int index = query[1];
                int value = query[2];

                // Remove old peak status
                for (int i = index - 1; i <= index + 1; i++) {
                    if (isPeak(i)) {
                        add(i, -1);
                    }
                }

                // Update the number
                nums[index] = value;

                // Add new peak status
                for (int i = index - 1; i <= index + 1; i++) {
                    if (isPeak(i)) {
                        add(i, 1);
                    }
                }
            }
        }

        return answer;
    }
}