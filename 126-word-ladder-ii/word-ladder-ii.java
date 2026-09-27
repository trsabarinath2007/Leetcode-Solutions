import java.util.*;

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return ans;
        }

        // Map to store parents for reconstructing paths: child -> list of valid parents in shortest path
        Map<String, List<String>> parentMap = new HashMap<>();
        // Map to store the shortest distance/level from beginWord to each visited word
        Map<String, Integer> distanceMap = new HashMap<>();
        
        // BFS Initialization
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distanceMap.put(beginWord, 0);

        boolean found = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                int currDist = distanceMap.get(curr);

                if (curr.equals(endWord)) {
                    found = true;
                }

                char[] chars = curr.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char originalChar = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue;
                        chars[j] = c;
                        String nextWord = new String(chars);

                        if (dict.contains(nextWord)) {
                            // First time visiting this word
                            if (!distanceMap.containsKey(nextWord)) {
                                distanceMap.put(nextWord, currDist + 1);
                                parentMap.computeIfAbsent(nextWord, k -> new ArrayList<>()).add(curr);
                                queue.offer(nextWord);
                            } 
                            // Reached this word via another path at the same shortest distance level
                            else if (distanceMap.get(nextWord) == currDist + 1) {
                                parentMap.get(nextWord).add(curr);
                            }
                        }
                    }
                    chars[j] = originalChar;
                }
            }
            if (found) break; // Reached target level, no need to explore deeper
        }

        // DFS Backtracking to build transformation paths from endWord back to beginWord
        if (found) {
            List<String> path = new ArrayList<>();
            path.add(endWord);
            dfs(endWord, beginWord, parentMap, path, ans);
        }

        return ans;
    }

    private void dfs(String word, String beginWord, Map<String, List<String>> parentMap, List<String> path, List<List<String>> ans) {
        if (word.equals(beginWord)) {
            List<String> fullPath = new ArrayList<>(path);
            Collections.reverse(fullPath);
            ans.add(fullPath);
            return;
        }

        if (!parentMap.containsKey(word)) return;

        for (String parent : parentMap.get(word)) {
            path.add(parent);
            dfs(parent, beginWord, parentMap, path, ans);
            path.remove(path.size() - 1);
        }
    }
}