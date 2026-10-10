class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        // If target is out of bounds, or (target + totalSum) is odd, no solution exists
        if (target > totalSum || target < -totalSum || (target + totalSum) % 2 != 0) {
            return 0;
        }
        
        int s1 = (target + totalSum) / 2;
        if (s1 < 0) {
            return 0;
        }
        
        // DP array to count the number of subsets with sum equal to s1
        int[] dp = new int[s1 + 1];
        dp[0] = 1; // Base case: one way to get sum 0 (using an empty subset)
        
        for (int num : nums) {
            for (int j = s1; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        
        return dp[s1];
    }
}