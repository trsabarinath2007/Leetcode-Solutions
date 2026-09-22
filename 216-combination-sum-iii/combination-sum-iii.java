import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int k, int target, int start) {
        // Base case 1: found a valid combination
        if (current.size() == k && target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Base case 2: exceeded size k or target exceeded
        if (current.size() >= k || target < 0) {
            return;
        }

        // Try numbers from start up to 9
        for (int i = start; i <= 9; i++) {
            current.add(i);
            backtrack(result, current, k, target - i, i + 1); // move to next number
            current.remove(current.size() - 1); // backtrack
        }
    }
}