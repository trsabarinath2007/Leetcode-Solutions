class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] counts = new int[100];
        int totalPairs = 0;
        for (int[] d : dominoes) {
            int key = d[0] < d[1] ? d[0] * 10 + d[1] : d[1] * 10 + d[0];
            totalPairs += counts[key];
            counts[key]++;
        }
        return totalPairs;
    }
}