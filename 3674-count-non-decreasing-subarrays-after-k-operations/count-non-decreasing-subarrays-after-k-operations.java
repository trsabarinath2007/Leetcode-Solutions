
class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        long cost = 0;

        java.util.Deque<Integer> deque = new java.util.ArrayDeque<>();

        int right = n - 1;

        for (int left = n - 1; left >= 0; left--) {

            while (!deque.isEmpty() &&
                   nums[deque.peekFirst()] <= nums[left]) {

                int index = deque.pollFirst();
                int end = deque.isEmpty()
                        ? right + 1
                        : deque.peekFirst();

                cost += (long) (end - index) *
                        (nums[left] - nums[index]);
            }

            deque.addFirst(left);

            while (cost > k) {
                cost -= Math.max(0,
                        nums[deque.peekLast()] - nums[right]);

                if (deque.peekLast() == right) {
                    deque.pollLast();
                }

                right--;
            }

            ans += right - left + 1;
        }

        return ans;
    }
}
