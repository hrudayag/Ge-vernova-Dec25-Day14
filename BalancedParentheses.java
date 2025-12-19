public class BalancedParentheses {
    static class Stack {
        char[] stack;
        int top;
        Stack(int size) {
            stack = new char[size];
            top = -1;
        }
        void push(char ch) {
            top++;
            stack[top] = ch;
        }
        char pop() {
            char removed = stack[top];
            top--;
            return removed;
        }
        char peek() {
            return stack[top];
        }
        boolean isEmpty() {
            return top == -1;
        }
        int size() {
            return top + 1;
        }
    }
    static boolean isBalanced(String expression) {
        Stack stack = new Stack(expression.length());
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            }
            if (ch == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String expression = "(1/3)*(4-3)+(-1";
        boolean result = isBalanced(expression);
        System.out.println(result);
    }
}
