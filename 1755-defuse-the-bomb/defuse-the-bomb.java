
class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            if (k > 0) {
                for (int j = 1; j <= k; j++) {
                    result[i] += code[(i + j) % n];
                }
            } else if (k < 0) {
                for (int j = 1; j <= -k; j++) {
                    result[i] += code[(i - j + n) % n];
                }
            }
        }

        return result;
    }
}
