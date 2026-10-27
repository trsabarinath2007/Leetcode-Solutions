
class Solution {
    public String longestNiceSubstring(String s) {
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                boolean nice = true;

                for (int k = 0; k < sub.length(); k++) {
                    char c = sub.charAt(k);

                    if (Character.isLowerCase(c)) {
                        if (!sub.contains(String.valueOf(Character.toUpperCase(c)))) {
                            nice = false;
                            break;
                        }
                    } else {
                        if (!sub.contains(String.valueOf(Character.toLowerCase(c)))) {
                            nice = false;
                            break;
                        }
                    }
                }

                if (nice && sub.length() > result.length()) {
                    result = sub;
                }
            }
        }

        return result;
    }
}
