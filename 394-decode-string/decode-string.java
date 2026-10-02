class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder currentStr = new StringBuilder();
        int currentNum = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                currentNum = currentNum * 10 + (c - '0');
            } else if (c == '[') {
                numStack.push(currentNum);
                strStack.push(currentStr);
                currentStr = new StringBuilder();
                currentNum = 0;
            } else if (c == ']') {
                StringBuilder prevStr = strStack.pop();
                int count = numStack.pop();
                for (int i = 0; i < count; i++) {
                    prevStr.append(currentStr);
                }
                currentStr = prevStr;
            } else {
                currentStr.append(c);
            }
        }

        return currentStr.toString();
    }
}