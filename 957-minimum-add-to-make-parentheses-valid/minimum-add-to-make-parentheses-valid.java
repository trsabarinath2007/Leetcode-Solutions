class Solution {
    public int minAddToMakeValid(String s) {
        int openCount = 0;
        int closeCount = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                openCount++;
            } else {
                if (openCount > 0) {
                    openCount--; // Matched with an open parenthesis
                } else {
                    closeCount++; // Unmatched closing parenthesis
                }
            }
        }

        // Total additions needed = unmatched '(' + unmatched ')'
        return openCount + closeCount;
    }
}