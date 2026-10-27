
class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int max = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0 && nums[i] <= threshold) {
                int j = i;

                while (j < n && nums[j] <= threshold &&
                       (j == i || nums[j] % 2 != nums[j - 1] % 2)) {
                    j++;
                }

                max = Math.max(max, j - i);
                i = j - 1;
            }
        }

        return max;
    }
}
