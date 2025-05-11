class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> openStack = new Stack<>(); // indexes of '('
        Stack<Integer> starStack = new Stack<>(); // indexes of '*'

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                openStack.push(i);
            } else if (ch == '*') {
                starStack.push(i);
            } else {
                if (!openStack.isEmpty()) {
                    openStack.pop();
                } else if (!starStack.isEmpty()) {
                    starStack.pop();
                } else {
                    return false;
                }
            }
        }

        // Now match remaining '(' with '*'
        while (!openStack.isEmpty() && !starStack.isEmpty()) {
            if (openStack.peek() > starStack.peek()) {
                return false; // '*' comes before '(', not valid
            }
            openStack.pop();
            starStack.pop();
        }

        return openStack.isEmpty(); // if any '(' left, it's invalid
    }
}