class Solution {
    public int lastRemaining(int n) {
        int head = 1;
        int step = 1;
        boolean left = true;
        int remaining = n;

        while (remaining > 1) {
            // We update head if we are eliminating from left-to-right, 
            // or if we are eliminating from right-to-left and the count of elements is odd.
            if (left || remaining % 2 == 1) {
                head += step;
            }
            step *= 2;
            remaining /= 2;
            left = !left; // Toggle direction
        }

        return head;
    }
}