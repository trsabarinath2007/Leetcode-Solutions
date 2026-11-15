class Solution {
    public int numOfSubarrays(int[] arr) {
        long oddCount = 0;
        long evenCount = 1; // Base case: prefix sum 0 is even
        long currentSum = 0;
        long totalSubarrays = 0;
        int MOD = 1_000_000_007;

        for (int num : arr) {
            currentSum += num;
            
            if (currentSum % 2 == 1) {
                totalSubarrays += evenCount;
                oddCount++;
            } else {
                totalSubarrays += oddCount;
                evenCount++;
            }
            
            totalSubarrays %= MOD;
        }

        return (int) totalSubarrays;
    }
}