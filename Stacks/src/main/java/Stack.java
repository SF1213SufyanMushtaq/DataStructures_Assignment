public class Stack {

    private int[] stackArray;
    private int index;  // Index to track the position of the next available slot in the stack
    private int arraySize;  // The size of the array (maximum capacity)

    // Constructor to initialize the stack with a given array size
    public Stack(int arraySize) {
        this.arraySize = arraySize;
        stackArray = new int[arraySize];
        index = 0;  // Initially, the stack is empty
    }

    // Method to push an element onto the stack
    public void push(int element) {
        if (isFull()) {
            System.out.println("Stack is full! Cannot push element.");
        } else {
            stackArray[index] = element;  // Add element to the stack at the current index
            index++;  // Increment index to point to the next available slot
            System.out.println("Pushed " + element + " to the stack.");
        }
    }

    // Method to pop an element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Cannot pop element.");
            return -1;  // Indicating empty stack
        } else {
            index--;  // Decrement index to point to the last element
            int poppedElement = stackArray[index];  // Get the element at the current index
            System.out.println("Popped " + poppedElement + " from the stack.");
            return poppedElement;
        }
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return index == 0;  // If index is 0, the stack is empty
    }

    // Method to check if the stack is full
    public boolean isFull() {
        return index == arraySize;  // If index reaches array size, the stack is full
    }

    // Method to return the size of the stack (number of elements in the stack)
    public int size() {
        return index;  // The number of elements is the same as the current index
    }

    // Main method for testing the stack class
    public static void main(String[] args) {
        Stack stack = new Stack(5);  // Create a stack with an array size of 5

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        System.out.println("Stack size: " + stack.size());  // Output: 5

        stack.push(60);  // This will print "Stack is full! Cannot push element."

        System.out.println("Popped element: " + stack.pop());  // Output: 50

        System.out.println("Stack size: " + stack.size());  // Output: 4
        System.out.println("Is the stack empty? " + stack.isEmpty());  // Output: false
    }
}
