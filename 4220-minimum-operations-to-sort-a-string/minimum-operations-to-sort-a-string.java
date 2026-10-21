class Solution {
    public int minOperations(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        
        // Check if already sorted
        boolean sorted = true;
        for (int i = 0; i < n - 1; i++) {
            if (chars[i] > chars[i + 1]) {
                sorted = false;
                break;
            }
        }
        if (sorted) return 0;
        
        // If length is 2 and not sorted, it's impossible because any operation requires a proper substring
        if (n == 2) return -1;
        
        char minChar = chars[0];
        char maxChar = chars[0];
        for (char c : chars) {
            if (c < minChar) minChar = c;
            if (c > maxChar) maxChar = c;
        }
        
        // Check for 1 operation: min at start (not full string) or max at end (not full string)
        if (chars[0] == minChar || chars[n - 1] == maxChar) {
            return 1;
        }
        
        // Check for 3 operations: only max at the beginning and only min at the end
        if (chars[0] == maxChar && chars[n - 1] == minChar) {
            // Verify if they are unique
            int maxCount = 0, minCount = 0;
            for (char c : chars) {
                if (c == maxChar) maxCount++;
                if (c == minChar) minCount++;
            }
            if (maxCount == 1 && minCount == 1) {
                return 3;
            }
        }
        
        return 2;
    }
}