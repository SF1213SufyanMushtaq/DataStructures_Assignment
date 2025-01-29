import java.util.Stack;

public class ReverseString {

    public static String reverseString(String inputString) {
        Stack<Character> stack = new Stack<>();


        for (char ch : inputString.toCharArray()) {
            stack.push(ch);
        }


        StringBuilder reversedString = new StringBuilder();
        while (!stack.isEmpty()) {
            reversedString.append(stack.pop());
        }

        return reversedString.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseString("Hello, World!"));
    }
}