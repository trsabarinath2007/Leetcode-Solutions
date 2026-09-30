class NumArray {
    private int[] tree;
    private int[] nums;
    private int n;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.tree = new int[n + 1];

        // Initialize Binary Indexed Tree
        for (int i = 0; i < n; i++) {
            initBIT(i, nums[i]);
        }
    }

    private void initBIT(int i, int val) {
        i++; // 1-based indexing for BIT
        while (i <= n) {
            tree[i] += val;
            i += i & (-i);
        }
    }

    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val; // update original array
        initBIT(index, diff); // propagate difference in BIT
    }

    private int prefixSum(int i) {
        int sum = 0;
        i++; // 1-based indexing
        while (i > 0) {
            sum += tree[i];
            i -= i & (-i);
        }
        return sum;
    }

    public int sumRange(int left, int right) {
        return prefixSum(right) - prefixSum(left - 1);
    }
}