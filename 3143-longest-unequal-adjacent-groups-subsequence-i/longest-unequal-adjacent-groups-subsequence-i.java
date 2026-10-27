class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        if (words.length == 0) {
            return result;
        }

        // Always include the first element
        result.add(words[0]);
        int lastGroup = groups[0];

        // Iterate through the rest and add elements when the group changes
        for (int i = 1; i < words.length; i++) {
            if (groups[i] != lastGroup) {
                result.add(words[i]);
                lastGroup = groups[i];
            }
        }

        return result;
    }
}