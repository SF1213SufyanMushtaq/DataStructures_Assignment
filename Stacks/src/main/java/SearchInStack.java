import java.util.Stack;

public class SearchInStack {

    public static int searchInStack(Stack<Integer> stack, int element) {
        Stack<Integer> tempStack = new Stack<>();
        int position = -1;
        int index = 0;

        // Search for the element in the stack
        while (!stack.isEmpty()) {
            int current = stack.pop();
            tempStack.push(current);
            if (current == element) {
                position = index;
            }
            index++;
        }


        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }

        return position;
    }

    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<>();
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        myStack.push(40);
        myStack.push(50);

        System.out.println(searchInStack(myStack, 40));
    }
}