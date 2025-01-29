import java.util.Stack;

public class ReverseNumber {

    public static int reverseNumber(int inputNumber) {
        Stack<Character> stack = new Stack<>();
        String numberString = Integer.toString(inputNumber);

        for (char digit : numberString.toCharArray()) {
            stack.push(digit);
        }


        StringBuilder reversedNumber = new StringBuilder();
        while (!stack.isEmpty()) {
            reversedNumber.append(stack.pop());
        }

        return Integer.parseInt(reversedNumber.toString());
    }

    public static void main(String[] args) {
        System.out.println(reverseNumber(12345));
    }
}