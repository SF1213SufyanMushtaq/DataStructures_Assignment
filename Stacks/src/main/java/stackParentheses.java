package Stack;
import java.util.*;

public class stackParentheses {

    public static boolean isBalanced(String equation) {
        Stack<Character> stack = new Stack<>();

        for (char ch : equation.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty() || !isMatching(stack.pop(), ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isMatching(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }

    public static void main(String[] args) {
        String equation1 = "((4^7 - 86) *(4/4))/(7+2)";
        String equation2 = "((22-7) * (5/2) ) / (2+6))";
        String equation3 = "{(()[)}]";

        System.out.println("Equation is balanced? " + isBalanced(equation1));
        System.out.println("Equation is balanced? " + isBalanced(equation2));
        System.out.println("Equation is balanced? " + isBalanced(equation3));
    }
}