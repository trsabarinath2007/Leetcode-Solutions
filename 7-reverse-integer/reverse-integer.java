class Solution {
    public int reverse(int x) {
        long rev = 0;                 
           int n = x;

        while (n != 0) {
            int digit = n % 10;
            n /= 10;
            rev = rev * 10 + digit;
            if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
                return 0;
            }
        }

        return (int) rev;
    }
}

       